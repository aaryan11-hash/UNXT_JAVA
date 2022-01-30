package MAIN.Repository;

import MAIN.Domain.Course;
import MAIN.Domain.Student;
import MAIN.Repository.Scripts.SqlQueryScript;
import MAIN.Service.Cache.CacheStore;
import MAIN.Service.DataService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StudentRepositoryImpl implements CrudRepository<Student> {


    //Eg of Generics and functional composition
    @Override
    public List<Student> getList() {
        var studentList = new ArrayList<Student>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){


            var preparedStatement = conn.prepareStatement(SqlQueryScript.FETCH_STUDENT_DATA);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                studentList.add(
                        new Student(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                Integer.parseInt(resultSet.getString(3)))
                );
            }
            return studentList;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentList;
    }

    //Eg of Generics and functional composition
    @Override
    public void deleteEntity(int studentId) {

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var prepStmt1 = conn.prepareStatement("delete from student where student_id=?");
            prepStmt1.setInt(1,studentId);
            prepStmt1.execute();

            var prepStmt2 = conn.prepareStatement("delete from course_student where student_id=?");
            prepStmt2.setInt(1,studentId);
            prepStmt2.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Student getOneEntity(int entityId) {
        return null;
    }

    public void saveNewStudent(String studentName,List<Course> courses){

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var prepStmt1 = conn.prepareStatement("insert into student(student_name,student_roll_no) values(?,?)");
            prepStmt1.setString(1,studentName);
            prepStmt1.setInt(2, studentName.length()+new Random().nextInt());
            prepStmt1.execute();


            courses.forEach(course -> {
                try {
                    var prepStmt2 = conn.prepareStatement("insert into course_student(course_id,student_id) values (?,(select max(student_id) from student))");
                    prepStmt2.setInt(1,course.getCourseId());
                    prepStmt2.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Student> getStudentsWithSubject(String subjectName) {

        var studentList = new ArrayList<Student>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var prepStmt1 = conn.prepareStatement("select s.student_id,s.student_name,s.student_roll_no from course c, student s, course_student cs where s.student_id = cs.student_id and cs.course_id = c.course_id and c.course_name = ?");
            prepStmt1.setString(1,subjectName.toUpperCase());
            prepStmt1.execute();

            var resultSet = prepStmt1.getResultSet();

            while(resultSet.next()){

                studentList.add(
                        new Student(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                Integer.parseInt(resultSet.getString(3))
                        )
                );

            }


        }catch (SQLException e){
            e.printStackTrace();
        }

            return studentList;
    }

    public List<Student> getStudentWithTeacher(String teacherName) {
        var studentList = new ArrayList<Student>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var prepStmt1 = conn.prepareStatement("select s.student_id,s.student_name,t.teacher_id,t.teacher_name from student s, teacher t, course_student cs where s.student_id = cs.student_id and cs.course_id = t.course_id and t.teacher_name = ?;");
            prepStmt1.setString(1,teacherName);
            prepStmt1.execute();

            var resultSet = prepStmt1.getResultSet();

            while(resultSet.next()){

                studentList.add(
                        new Student(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                Integer.parseInt(resultSet.getString(3))
                        )
                );

            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return studentList;

    }


}

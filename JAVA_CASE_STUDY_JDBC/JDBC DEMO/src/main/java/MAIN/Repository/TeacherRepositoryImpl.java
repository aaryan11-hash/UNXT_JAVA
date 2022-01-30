package MAIN.Repository;

import MAIN.Domain.Course;
import MAIN.Domain.Teacher;
import MAIN.Repository.Scripts.SqlQueryScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements CrudRepository<Teacher>{


    //Eg of Generics and functional composition
    @Override
    public List<Teacher> getList() {
        var teacherList = new ArrayList<Teacher>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){


            var preparedStatement = conn.prepareStatement(SqlQueryScript.FETCH_TEACHER_DATA);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                teacherList.add(
                        new Teacher(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                Integer.parseInt(resultSet.getString(4)))
                );
            }
            return teacherList;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacherList;
    }

    //Eg of Generics and functional composition
    @Override
    public void deleteEntity(int teacherId) {

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var preparedStatement = conn.prepareStatement("delete from teacher where teacher_id=?");
            preparedStatement.setInt(1,teacherId);

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getOneEntity(int entityId) {

        var name = "NAME";
        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var preparedStatement = conn.prepareStatement("select teacher_name from teacher where teacher_id=?");
            preparedStatement.setInt(1,entityId);
            preparedStatement.execute();

            var resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                name = resultSet.getString(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Teacher(null,name,null,null);
    }

    public List<Teacher> getTeacherWithSubject(String subjectName) {

        var teacherList = new ArrayList<Teacher>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){


            var preparedStatement = conn.prepareStatement("select t.teacher_id, t.teacher_name, t.teacher_certificate, c.course_id, c.course_name  from course c, teacher t where t.course_id = c.course_id and c.course_name = ?");
            preparedStatement.setString(1,subjectName);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                teacherList.add(
                        new Teacher(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                Integer.parseInt(resultSet.getString(4)))
                );
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacherList;
    }


    public void addTeacher(String teacherName, String certificateLoc, int courseId) {

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var preparedStatement = conn.prepareStatement("insert into teacher(teacher_name,teacher_certificate,course_id) values (?,?,?)");
            preparedStatement.setString(1,teacherName);
            preparedStatement.setString(2,certificateLoc);
            preparedStatement.setInt(3,courseId);

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void updateDetails(int teacherId,int op, String update) {

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

         if(op == 1){
             var preparedStatement = conn.prepareStatement("update teacher set teacher_name = ? where teacher_id=?");
             preparedStatement.setString(1,update);
             preparedStatement.setInt(2,teacherId);
             preparedStatement.execute();
         }else if(op == 2){
             var preparedStatement = conn.prepareStatement("update teacher set teacher_certificate = ? where teacher_id=?");
             preparedStatement.setString(1,update);
             preparedStatement.setInt(2,teacherId);
             preparedStatement.execute();
         }else if(op == 3){

             var preparedStatement = conn.prepareStatement("select * from course");
             preparedStatement.execute();

             var resultSet = preparedStatement.getResultSet();

             while (resultSet.next()){
                 if(update.contentEquals(resultSet.getString(2))){

                     var prepStmt2 = conn.prepareStatement("update teacher set course_id = ? where teacher_id=?");
                     prepStmt2.setInt(1,Integer.parseInt(resultSet.getString(1)));
                     prepStmt2.setInt(2,teacherId);
                     prepStmt2.execute();
                     break;
                 }
             }


         }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

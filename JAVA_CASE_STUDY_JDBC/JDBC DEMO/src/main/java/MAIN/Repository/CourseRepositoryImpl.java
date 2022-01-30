package MAIN.Repository;

import MAIN.Domain.Course;
import MAIN.Repository.Scripts.SqlQueryScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CrudRepository<Course>{

    //Eg of Generics and functional composition
    @Override
    public List<Course> getList(){

        var courseList = new ArrayList<Course>();

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){


            var preparedStatement = conn.prepareStatement(SqlQueryScript.FETCH_COURSE_DATA);
            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                courseList.add(
                        new Course(Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3))
                );
            }
            return courseList;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }

    //Eg of Generics and functional composition
    @Override
    public void deleteEntity(int courseId) {
        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var preparedStatement = conn.prepareStatement("delete from course where course_id=?");
            preparedStatement.setInt(1,courseId);
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Course getOneEntity(int entityId) {
        return null;
    }


    public void addNewCourse(String courseName) {

        try(Connection conn = DriverManager.getConnection(SqlQueryScript.CONNECTION_URL,SqlQueryScript.USER_NAME,SqlQueryScript.PASSWORD)){

            var preparedStatement = conn.prepareStatement("insert into course(course_name) values (?)");
            preparedStatement.setString(1,courseName.toUpperCase());
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}

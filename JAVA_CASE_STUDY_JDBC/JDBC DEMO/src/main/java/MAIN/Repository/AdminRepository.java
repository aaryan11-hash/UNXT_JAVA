package MAIN.Repository;

import MAIN.Repository.Scripts.SqlQueryScript;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminRepository {


    public void dropTable(){

        List.of(SqlQueryScript.DROP_STUDENT_TABLE,SqlQueryScript.DROP_TEACHER_TABLE,SqlQueryScript.DROP_COURSE_TABLE,SqlQueryScript.DROP_COURSE_STUDENT_TABLE)
                .forEach(this::executeQuery);

    }

    public void createEntities(){

      List.of(SqlQueryScript.COURSE_TABLE,SqlQueryScript.TEACHER_TABLE,SqlQueryScript.STUDENT_TABLE,SqlQueryScript.COURSE_STUDENT_TABLE)
                .forEach(this::executeQuery);
    }

    public void enterReadyData(){

       List.of(SqlQueryScript.COURSE_STUDENT_ENTRY,SqlQueryScript.COURSE_ENTRY,SqlQueryScript.TEACHER_ENTRY,SqlQueryScript.STUDENT_ENTRY)
               .forEach(this::executeQuery);
    }

    public void executeQuery(String sqlQuery){

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/case_study","root","root")){

            var preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

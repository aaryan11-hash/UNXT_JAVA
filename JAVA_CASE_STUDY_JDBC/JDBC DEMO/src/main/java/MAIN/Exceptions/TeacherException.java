package MAIN.Exceptions;

import java.sql.SQLException;

public class TeacherException extends SQLException {

    public TeacherException(String reason,Throwable cause) {
        System.out.println(reason);
        cause.printStackTrace();
    }

}

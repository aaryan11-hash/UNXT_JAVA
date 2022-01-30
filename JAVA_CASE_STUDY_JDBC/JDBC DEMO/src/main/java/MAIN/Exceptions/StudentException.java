package MAIN.Exceptions;

import java.sql.SQLException;

public class StudentException extends SQLException{

    public StudentException(String reason,Throwable cause) {
        System.out.println(reason);
        cause.printStackTrace();
    }

}

package MAIN.Exceptions;

import java.sql.SQLException;

public class CourseException extends SQLException {

    public CourseException(String reason, Throwable cause) {
        System.out.println(reason);
        cause.printStackTrace();
    }

}

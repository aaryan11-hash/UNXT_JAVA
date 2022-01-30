package MAIN.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Course {

    private Integer courseId;
    private String courseName;
    private String courseCertificate;

}

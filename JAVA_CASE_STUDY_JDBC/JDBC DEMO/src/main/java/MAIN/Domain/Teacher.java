package MAIN.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Teacher {

    private Integer teacherId;
    private String teacherName;
    private String teacherCertificate;
    private Integer courseId;


}

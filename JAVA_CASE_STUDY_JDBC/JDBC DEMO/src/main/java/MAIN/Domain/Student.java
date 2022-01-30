package MAIN.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {

    private Integer studentId;
    private String studentName;
    private Integer studentRollNo;


}

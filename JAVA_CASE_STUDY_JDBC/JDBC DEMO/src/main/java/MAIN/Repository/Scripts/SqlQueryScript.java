package MAIN.Repository.Scripts;

public class SqlQueryScript {

    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/case_study";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";

    public static final String FETCH_COURSE_DATA = "select * from course";
    public static final String FETCH_TEACHER_DATA = "select * from teacher";
    public static final String FETCH_STUDENT_DATA = "select * from student";

    public static final String DROP_STUDENT_TABLE = "drop table if exists student";
    public static final String DROP_TEACHER_TABLE = "drop table if exists teacher";
    public static final String DROP_COURSE_TABLE = "drop table if exists course";
    public static final String DROP_COURSE_STUDENT_TABLE = "drop table if exists course_student";

    public static final String TEACHER_TABLE = """
                create table teacher(
                      teacher_id int(11) primary key auto_increment,
                      teacher_name varchar(40) not null,
                      teacher_certificate varchar(40) unique,
                      course_id int(11),
                      constraint `fkey_1` foreign key (course_id) references course(course_id)
                      )engine = InnoDB;
                """;

    public static final String COURSE_STUDENT_TABLE = """
                create table course_student(
                `course_id` int(11) not null,
                `student_id` int(11) not null
                )engine = InnoDB;
                """;

    public static final String STUDENT_TABLE = """
                create table student(
                `student_id` int(11) primary key not null unique auto_increment,
                `student_name` varchar(40) not null,
                `student_roll_no` int(11) not null unique
                )engine = InnoDB;
               """;

    public static final String COURSE_TABLE = """
                create table course(
                `course_id` int(11) primary key not null unique auto_increment,
                `course_name` varchar(40) not null,
                `course_certificate` varchar(40) unique
                )engine = InnoDB;
                """;

    public static final String TEACHER_ENTRY = """
              insert into teacher(teacher_id,teacher_name,course_id) values
                                                            (1,"Mukesh Rajan",1),
                                                            (2,"Rajesh Mishra",1),
                                                            (3,"Anvita Karilkr",2),
                                                            (4,"Brijesh Pnadey",3),
                                                            (5,"Preeti Mulay",4);
            """;

    public static final String COURSE_ENTRY = """
                   insert into course(course_id,course_name) values
                                                            (1,"C++"),
                                                            (2,"JAVA"),
                                                            (3,"SQL"),
                                                            (4,"COMPILER");
            """;

    public static final String STUDENT_ENTRY = """
                   insert into student(student_id,student_name,student_roll_no) values\s
                                                            (1,"Aaryan Srivastava",1),
                                                            (2,"Sanket Shevkar",2),
                                                            (3,"Gatij Taranekar",3),
                                                            (4,"Ayush Tiwari",4),
                                                            (5,"Himank Jain",5),
                                                            (6,"Shashank Sundar",6),
                                                            (7,"Gayatri Pingale",7);
            """;

    public static final String COURSE_STUDENT_ENTRY = """
                   insert into course_student(course_id,student_id) values
                                                            (1,1),
                                                            (1,2),
                                                            (1,3),
                                                            (1,4),
                                                            (1,5),
                                                            (2,1),
                                                            (2,2),
                                                            (3,4),
                                                            (3,5),
                                                            (3,6),
                                                            (3,7),
                                                            (4,1),
                                                            (4,7);
                
            """;

}

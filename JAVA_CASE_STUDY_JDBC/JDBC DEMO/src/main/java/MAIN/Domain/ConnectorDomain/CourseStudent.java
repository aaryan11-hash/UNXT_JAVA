package MAIN.Domain.ConnectorDomain;

public class CourseStudent {

    private Integer courseId;
    private Integer studentId;

    public CourseStudent(Integer courseId, Integer studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}

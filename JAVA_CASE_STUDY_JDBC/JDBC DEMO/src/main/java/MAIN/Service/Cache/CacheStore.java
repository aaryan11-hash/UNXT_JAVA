package MAIN.Service.Cache;

import MAIN.Domain.Course;
import MAIN.Domain.Student;
import MAIN.Domain.Teacher;

import java.util.List;

public class CacheStore {

    private static List<Teacher> teacherBufferList;
    private static List<Student> studentBufferList;
    private static List<Course> courseBufferList;



    public static List<Teacher> getTeacherBufferList() {
        return teacherBufferList;
    }

    public void setTeacherBufferList(List<Teacher> teacherBufferList) {
        this.teacherBufferList = teacherBufferList;
    }

    public static List<Student> getStudentBufferList() {
        return studentBufferList;
    }

    public  void setStudentBufferList(List<Student> studentBufferList) {
        this.studentBufferList = studentBufferList;
    }

    public static List<Course> getCourseBufferList() {
        return courseBufferList;
    }

    public void setCourseBufferList(List<Course> courseBufferList) {
        this.courseBufferList = courseBufferList;
    }


}

package MAIN.Service;

import MAIN.Domain.Course;
import MAIN.Repository.CourseRepositoryImpl;
import MAIN.Repository.Scripts.SqlQueryScript;
import MAIN.Repository.StudentRepositoryImpl;
import MAIN.Repository.AdminRepository;
import MAIN.Repository.TeacherRepositoryImpl;
import MAIN.Service.Cache.CacheStore;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class DataService {

    private CourseRepositoryImpl courseRepository;
    private TeacherRepositoryImpl teacherRepository;
    private StudentRepositoryImpl studentRepository;
    private AdminRepository adminRepository;
    private ExecutorService executorService;
    private CacheStore cacheStore;
    private Scanner sc = new Scanner(System.in);

    public DataService(CourseRepositoryImpl courseRepository, TeacherRepositoryImpl teacherRepository, StudentRepositoryImpl studentRepository, AdminRepository adminRepository, CacheStore cacheStore) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
        this.cacheStore = cacheStore;
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
    }

    //PARALLEL EXECUTION WHICH WONT BLOCK THE MAIN FUNCTION THREAD
    public void initializeDb() {

        executorService.submit(() -> {
            adminRepository.dropTable();
            adminRepository.createEntities();
            adminRepository.enterReadyData();
        });

        System.out.println("DATABASE PURGE/RESET COMPLETE");

    }

    public void getStudentsWithSubject() {
        System.out.println("Enter the name of the subject that you wish to use as the search index");
        var subjectName = sc.nextLine();

        studentRepository.getStudentsWithSubject(subjectName)
                .forEach(System.out::println);
    }

    public void saveNewStudent() {

        var courseList = this.getCourseRepository().getList();
        var finalCourseList = new ArrayList<Course>();

        System.out.println("Enter student name");
        String name = sc.nextLine();
        System.out.println("Enter the course you want to take");
        courseList.forEach(System.out::println);

        String [] courseIdList = sc.nextLine().split(",");

        for(String str: courseIdList){
            for(Course course: courseList){
                if(course.getCourseId() == Integer.parseInt(str)) {
                    finalCourseList.add(course);
                }
            }
        }
        studentRepository.saveNewStudent(name,finalCourseList);
    }

    public void deleteStudentWithRollNo() {

        getAllStudents();
        System.out.println("Enter the roll no. of the student you want to delete");
        var rollNo = sc.nextInt();
        studentRepository.deleteEntity(rollNo);
    }

    public void getTeacherWithSubject() {

        //print all the courses in db
        System.out.println("Enter the name of the subject that you wish to use as the search index");
        var subjectName = sc.nextLine();
        teacherRepository.getTeacherWithSubject(subjectName)
                .forEach(System.out::println);
    }

    public void getStudentWithTeacher() {
        //print the details of all the teachers from db
        System.out.println("Enter the name of the teacher that you wish to use as search Index");
        var name = sc.nextLine();
        studentRepository.getStudentWithTeacher(name)
                .forEach(System.out::println);
    }

    public void saveNewTeacher() {

        System.out.println("Enter the details of the teacher");
        var teacherName = sc.nextLine();

        System.out.println("Enter the new course");
        var courseId = sc.nextInt();

        teacherRepository.addTeacher(teacherName,FileIOService.FILE_LOCATION,courseId);

    }

    public void addNewCourse() {
        System.out.println("Enter the name of the course you want to add");
        var courseName = sc.nextLine();
        courseRepository.addNewCourse(courseName);
    }

    public void deleteTeacherWithId() {
        //todo
        //Print the details of all the teachers in the database and then ask for user input;
        System.out.println("Enter the teacherId of the teacher you want to delete");
        var teacherId = sc.nextInt();
        this.teacherRepository.deleteEntity(teacherId);
    }


    public void updateStudent() {

        //todo
        //display the student list to the user
        System.out.println("Enter the roll no of the student you want to update details of");
        var rollNo = sc.nextInt();
        //display all the attribultes of student to user and ask for input
        //1. change student name
        //2. change student certificate loc
        //3. change student birthdate
        //5. change student courses
        //for course print all the courses the student is taking and ask to pick one course
        //then ask user what to do with that course stream
    }

    public void getAllStudents() {
        System.out.println("STUDENT LIST ==>");
        this.getStudentRepository()
                .getList()
                .forEach(System.out::println);
    }

    public void updateTeacher() {

        //CODE TO UPDATE TEACHER DETAILS
        this.teacherRepository.getList().forEach(System.out::println);
        System.out.println("Enter the teacher id of the student you want to update details of");
        var teacherId = sc.nextInt();
        System.out.println("""
                WHAT DO YOU WANT TO CHANGE?
                1. NAME
                2. CERTIFICATE LOCATION
                3. COURSE SPECIALITY
                """);

        var op = sc.nextInt();

        if(op == 3) {
            this.courseRepository.getList().forEach(System.out::println);
        }

        System.out.println("Enter the new details for the given field");
        var update = sc.next();

        teacherRepository.updateDetails(teacherId,op,update);

    }

    public void getAllCourses() {
        System.out.println("LIST OF COURSES ==>");
        this.getCourseRepository().getList()
                .forEach(System.out::println);
    }


    public void getAllTeachers() {
        this.teacherRepository.getList()
                .forEach(System.out::println);
    }

    public void initializeState(){

    }

    public void deleteCourse() {
        System.out.println("SELECT THE COURSE NO. YOU WANT TO DELETE");
        this.getAllCourses();
        var courseId = sc.nextInt();
        this.courseRepository.deleteEntity(courseId);
    }


    public void printCertificate() {

        this.getAllTeachers();
        System.out.println("Enter the id of the teacher whose certificate you want to view");
        var teacherId = sc.nextInt();

        try {
            FileIOService.printCertificate(this.teacherRepository.getOneEntity(teacherId).getTeacherName());
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}

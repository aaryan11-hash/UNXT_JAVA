package MAIN;

import MAIN.Repository.*;
import MAIN.Service.Cache.CacheStore;
import MAIN.Service.DataService;
import MAIN.Service.FileIOService;

import java.io.IOException;
import java.util.Scanner;

public class Entry {

    private static Scanner sc = new Scanner(System.in);
    private static DataService dataService = new DataService(new CourseRepositoryImpl(),new TeacherRepositoryImpl(),new StudentRepositoryImpl(),new AdminRepository(), new CacheStore());


    public static void main(String[] args) throws IOException {
        System.out.println("INSTITUTE MANAGEMENT SYSTEM");
        while(true){
            System.out.println("""
                    PICK A DOMAIN
                    1. COURSE 
                    2. STUDENT
                    3. TEACHER
                    4. ADMIN
                    """);
            var domain = sc.nextInt();

            switch (domain){
                case 1 : {
                    System.out.println("""
                            SELECT THE OPERATION NO. YOU WANT TO PERFORM ON COURSE DATABASE
                            1. CREATE NEW COURSE
                            2. DELETE A COURSE
                            3. GET ALL COURSE AVAILABLE
                            """);
                    var op = sc.nextInt();

                    switch (op){
                        case 1 : dataService.addNewCourse();
                            break;
                        case 2 : dataService.deleteCourse();
                            break;
                        case 3 : dataService.getAllCourses();
                            break;
                    }

                }
                    break;

                case 2 : {
                    System.out.println("""
                            SELECT THE OPERATION NO. TO PERFORM ON STUDENT DATABASE
                            1. CREATE A NEW STUDENT
                            2. DELETE STUDENT 
                            3. GET STUDENT LIST
                            4. UPDATE STUDENT
                            5. FIND STUDENTS TAKING TAKING X COURSE
                            """);
                    var op = sc.nextInt();

                    switch (op){
                        case 1 : dataService.saveNewStudent();
                            break;
                        case 2 : dataService.deleteStudentWithRollNo();
                            break;
                        case 3 : dataService.getAllStudents();
                            break;
                        case 4 : dataService.updateStudent();
                            break;
                        case 5 : dataService.getStudentsWithSubject();;
                            break;

                    }

                }
                    break;
                case 3 : {
                    System.out.println("""
                            ENTER THE OPERATION NO. TO PERFORM ON TEACHER DATABASE"
                            1. CREATE A NEW TEACHER 
                            2. DELETE A TEACHER
                            3. UPDATE A TEACHER
                            4. FIND ALL STUDENTS TAUGHT BY A TEACHER
                            5. GET TEACHER LIST GIVING X COURSE
                            6. GET ALL TEACHERS DETAILS
                            7. PRINT TEACHER CERTIFICATE
                            """);
                    var op = sc.nextInt();
                    switch (op){

                        case 1: dataService.saveNewTeacher();
                            break;
                        case 2: dataService.deleteTeacherWithId();
                            break;
                        case 3: dataService.updateTeacher();
                            break;
                        case 4: dataService.getStudentWithTeacher();
                            break;
                        case 5: dataService.getTeacherWithSubject();
                            break;
                        case 6: dataService.getAllTeachers();
                            break;
                        //todo add all the details to the certificate
                        case 7: dataService.printCertificate();
                    }

                }
                    break;
                case 4 : {
                    System.out.println("""
                            THIS OPERATION WILL PURGE THE DATABASE AND REINSTANTIATE THE DATABASE WITH PRE-FIXED ENTRY.
                            """);
                    dataService.initializeDb();
                }
            }
        }

    }



}

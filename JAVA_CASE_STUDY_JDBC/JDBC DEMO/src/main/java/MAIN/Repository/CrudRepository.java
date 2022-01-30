package MAIN.Repository;

import MAIN.Domain.Course;
import MAIN.Domain.Student;
import MAIN.Domain.Teacher;
import MAIN.Repository.Scripts.SqlQueryScript;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//For implementing polymorphism and Loosely coupled POJOs
public interface CrudRepository<T> {

    List<T> getList();

    void deleteEntity(int entityId);

    T getOneEntity(int entityId);

}


package com.kovanlabs.studentmanagementsystem.dao;

import java.util.List;
import com.kovanlabs.studentmanagementsystem.model.StudentModel;

public interface StudentDAO {
    void addStudent(StudentModel student);
    List<StudentModel> getAllStudents();
    StudentModel getStudentById(int id);
    void updateStudent(StudentModel student);
    void deleteStudent(int id);
}
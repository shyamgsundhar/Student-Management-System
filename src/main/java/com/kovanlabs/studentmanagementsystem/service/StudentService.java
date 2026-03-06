package com.kovanlabs.studentmanagementsystem.service;

import java.util.List;
import com.kovanlabs.studentmanagementsystem.model.StudentModel;

public interface StudentService {

    void addStudent(StudentModel student);

    List<StudentModel> getAllStudents();

    StudentModel getStudentById(int id);

    void updateStudent(StudentModel student);

    void deleteStudent(int id);
}
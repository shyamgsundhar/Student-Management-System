package com.kovanlabs.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kovanlabs.studentmanagementsystem.dao.StudentDAO;
import com.kovanlabs.studentmanagementsystem.model.StudentModel;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void addStudent(StudentModel student) {
        studentDAO.addStudent(student);
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public StudentModel getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void updateStudent(StudentModel student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
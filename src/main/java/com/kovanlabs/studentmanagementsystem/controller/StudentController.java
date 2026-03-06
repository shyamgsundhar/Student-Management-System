package com.kovanlabs.studentmanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kovanlabs.studentmanagementsystem.model.StudentModel;
import com.kovanlabs.studentmanagementsystem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentModel student) {
        studentService.addStudent(student);
        return "Student Added Successfully";
    }

    @GetMapping("/all")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
        @PutMapping("/update")
    public String updateStudent(@RequestBody StudentModel student) {
        studentService.updateStudent(student);
        return "Student Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student Deleted Successfully";
    }
}
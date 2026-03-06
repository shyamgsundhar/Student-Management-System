package com.kovanlabs.studentmanagementsystem.controller;

import com.kovanlabs.studentmanagementsystem.model.CourseModel;
import com.kovanlabs.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String addCourse(@RequestBody CourseModel courseModel){
        return courseService.addCourse(courseModel);
    }

    @GetMapping("/display")
    public List<CourseModel> viewCourse(CourseModel courseModel){
        return courseService.viewCourse(courseModel);
    }

    @PutMapping("/update")
    public String updateCourse(@RequestBody CourseModel courseModel){
        return courseService.updateCourse(courseModel);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int courseId){
        return courseService.deleteCourse(courseId);
    }

    @GetMapping("/course-department")
    public List<CourseModel> getCourseWithDepartment(){
        return courseService.getCourseWithDepartment();
    }
}
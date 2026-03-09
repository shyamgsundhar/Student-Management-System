package com.kovanlabs.studentmanagementsystem.dao;

import com.kovanlabs.studentmanagementsystem.model.CourseModel;

import java.util.List;

public interface CourseDAO {
    String createCourse(CourseModel courseModel);
    List<CourseModel> displayCourse(CourseModel courseModel);
    String updateCourse(CourseModel courseModel);
    String deleteCourse(int courseId);

}

package com.kovanlabs.studentmanagementsystem.service;

import com.kovanlabs.studentmanagementsystem.dao.CourseDAO;
import com.kovanlabs.studentmanagementsystem.dao.CourseDAOImpl;
import com.kovanlabs.studentmanagementsystem.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    public CourseDAO courseDAO;

    @Autowired
    public CourseDAOImpl courseDAOImpl;

    public String addCourse(CourseModel courseModel){
        return courseDAO.createCourse(courseModel);
    }

    public List<CourseModel> viewCourse(CourseModel courseModel){
        return courseDAO.displayCourse(courseModel);
    }

    public String updateCourse(CourseModel courseModel){
        return courseDAO.updateCourse(courseModel);
    }

    public String deleteCourse(int courseId){
        return courseDAO.deleteCourse(courseId);
    }

    public List<CourseModel> getCourseWithDepartment(){
        return courseDAOImpl.getCourseWithDepartment();
    }

}

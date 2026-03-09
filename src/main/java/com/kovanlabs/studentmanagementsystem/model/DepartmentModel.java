package com.kovanlabs.studentmanagementsystem.model;

public class DepartmentModel {
    private Long departmentId;
    private String departmentName;
    private int facultyCount;
    private int courseCount;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setFacultyCount(int facultyCount) {
        this.facultyCount = facultyCount;
    }

    public int getFacultyCount() {
        return facultyCount;
    }

}

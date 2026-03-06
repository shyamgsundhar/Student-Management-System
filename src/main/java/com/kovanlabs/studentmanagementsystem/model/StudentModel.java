package com.kovanlabs.studentmanagementsystem.model;


public class StudentModel {
    int id;
    String student_name;
    String email;

    String department;
    public StudentModel(){

    }
    StudentModel(int id, String student_name, String email, String phone, String department){
        this.id=id;
        this.student_name=student_name;
        this.email=email;

        this.department=department;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

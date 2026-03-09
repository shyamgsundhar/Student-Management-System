package com.kovanlabs.studentmanagementsystem.dao;

import com.kovanlabs.studentmanagementsystem.model.CourseModel;
import com.kovanlabs.studentmanagementsystem.model.DepartmentModel;

import java.util.List;

public interface DepartmentDAO {
    String createDepartment(DepartmentModel departmentModel);
    List<DepartmentModel> displayDepartment(DepartmentModel departmentModel);
    String updateDepartment(DepartmentModel departmentModel);
    String deleteDepartment(int departmentId);

}

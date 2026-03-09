package com.kovanlabs.studentmanagementsystem.service;

import com.kovanlabs.studentmanagementsystem.dao.DepartmentDAO;
import com.kovanlabs.studentmanagementsystem.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    public String addDepartment(DepartmentModel departmentModel){
        return departmentDAO.createDepartment(departmentModel);
    }

    public List<DepartmentModel> viewDepartment(DepartmentModel departmentModel){
        return departmentDAO.displayDepartment(departmentModel);
    }

    public String updateDepartment(DepartmentModel departmentModel){
        return departmentDAO.updateDepartment(departmentModel);
    }

    public String deleteDepartment(int departmentId){
        return departmentDAO.deleteDepartment(departmentId);
    }
}
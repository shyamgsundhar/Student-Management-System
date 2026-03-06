package com.kovanlabs.studentmanagementsystem.controller;

import com.kovanlabs.studentmanagementsystem.model.DepartmentModel;
import com.kovanlabs.studentmanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public String addDepartment(@RequestBody DepartmentModel departmentModel){
        return departmentService.addDepartment(departmentModel);
    }

    @GetMapping("/display")
    public List<DepartmentModel> viewDepartment(DepartmentModel departmentModel){
        return departmentService.viewDepartment(departmentModel);
    }

    @PutMapping("/update")
    public String updateDepartment(@RequestBody DepartmentModel departmentModel){
        return departmentService.updateDepartment(departmentModel);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int departmentId){
        return departmentService.deleteDepartment(departmentId);
    }
}
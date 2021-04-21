package com.cosmos.controller;

import com.cosmos.model.Department;
import com.cosmos.pojo.DepartmentEmployeesPojo;
import com.cosmos.pojo.Departments;
import com.cosmos.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/adddummy")
    public Department saveDummyDepartment(){
        return departmentService.saveDummyDepartment();
    }
    @GetMapping("/{deptId}")
    public Department getDepartmentById(@PathVariable Long deptId){
        return departmentService.getDepartmentById(deptId);
    }
    @GetMapping("/{deptId}/emp")
    public DepartmentEmployeesPojo getAllEmployeeByDepartmentId(@PathVariable Long deptId){
        return departmentService.getAllEmployeeByDepartmentId(deptId);
    }
    @GetMapping()
    public Departments getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.savaDepartment(department);
    }
}

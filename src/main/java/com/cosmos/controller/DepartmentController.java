package com.cosmos.controller;

import com.cosmos.exception.DepartmentServiceException;
import com.cosmos.model.Department;
import com.cosmos.pojo.DepartmentEmployeesPojo;
import com.cosmos.pojo.Departments;
import com.cosmos.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/adddummy")
    public Department saveDummyDepartment(){
        return departmentService.saveDummyDepartment();
    }
    @GetMapping("/{deptId}")
    public Department getDepartmentById(@PathVariable Long deptId) throws DepartmentServiceException {
        Department department = null;
        try{
            department = departmentService.getDepartmentById(deptId);
        }catch (Exception ex){
            log.error("Department not available.");
            throw new DepartmentServiceException("Department not available: "+deptId);
            //throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Department not available.", ex);
        }
        return department;
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

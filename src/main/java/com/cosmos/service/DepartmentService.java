package com.cosmos.service;

import com.cosmos.model.Department;
import com.cosmos.pojo.Departments;
import com.cosmos.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department getDepartmentById(Long deptId) {
        return departmentRepository.findById(deptId).get();
    }

    public Department savaDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department saveDummyDepartment() {
        Department department = new Department();
        department.setDeptName("Dummy");
        department.setDeptLocation("India");
        return departmentRepository.save(department);
    }

    public Departments getAllDepartment() {
        List departmentList =departmentRepository.findAll();
        Departments departments = new Departments();
        departments.setDepartments(departmentList);
        return departments;
    }
}

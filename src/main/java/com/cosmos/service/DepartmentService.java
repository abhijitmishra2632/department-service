package com.cosmos.service;

import com.cosmos.model.Department;
import com.cosmos.pojo.DepartmentEmployeesPojo;
import com.cosmos.pojo.Departments;
import com.cosmos.pojo.Employees;
import com.cosmos.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DepartmentService {
    private String empHardCodedURL="http://localhost:9007/employee";
    private String employeeURL="http://EMPLOYEE-SERVICE/employee";

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RestTemplate restTemplate;
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

    public DepartmentEmployeesPojo getAllEmployeeByDepartmentId(Long deptId) {
        DepartmentEmployeesPojo departmentEmployeesPojo = new DepartmentEmployeesPojo();
        Department department= departmentRepository.findById(deptId).get();
        Employees employees=restTemplate.getForObject(employeeURL+"/filterdept/"+deptId , Employees.class);
        departmentEmployeesPojo.setDepartment(department);
        departmentEmployeesPojo.setEmployees(employees);
        return departmentEmployeesPojo;
    }
}

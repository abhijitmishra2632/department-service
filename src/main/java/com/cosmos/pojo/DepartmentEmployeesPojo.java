package com.cosmos.pojo;

import com.cosmos.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEmployeesPojo {
    private Department department;
    private Employees employees;
}

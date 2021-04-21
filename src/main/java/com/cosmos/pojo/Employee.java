package com.cosmos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long empId;
    private Long deptId;
    private String empName;
    private LocalDate empJdate;
    private Long empSalary;
    private LocalDate empDob;
}

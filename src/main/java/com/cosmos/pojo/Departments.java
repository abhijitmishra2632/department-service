package com.cosmos.pojo;

import com.cosmos.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departments {
    private List<Department> departments;
}

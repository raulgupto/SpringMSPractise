package com.springmspractise.departmentservice.service;


import com.springmspractise.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {


    List<Department> getAllDepartments();
    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);
}

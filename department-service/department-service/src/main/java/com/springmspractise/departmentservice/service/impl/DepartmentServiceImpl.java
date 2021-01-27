package com.springmspractise.departmentservice.service.impl;

import com.springmspractise.departmentservice.entity.Department;
import com.springmspractise.departmentservice.repository.DepartmentRepository;
import com.springmspractise.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        log.info("Inside getAllDepartments");
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment");
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

}

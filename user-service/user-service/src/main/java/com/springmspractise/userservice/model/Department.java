package com.springmspractise.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long id;
    private String departmentName;
    private String departmentManager;
    private String departmentCode;
}

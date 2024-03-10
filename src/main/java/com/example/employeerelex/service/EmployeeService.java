package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.entity.EmployeeEntity;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);
}

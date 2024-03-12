package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.dto.EmployeeSingInDto;
import com.example.employeerelex.dto.JwtAuthenticationResponse;
import com.example.employeerelex.entity.EmployeeEntity;

public interface AuthenticationService {
    EmployeeEntity createEmployee(EmployeeDto employeeEntity);

    JwtAuthenticationResponse singIn(EmployeeSingInDto employeeSingInDto);
}

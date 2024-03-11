package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeCreateDto;
import com.example.employeerelex.entity.EmployeeEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService {
    /*EmployeeEntity createEmployee(EmployeeCreateDto employee);*/
    UserDetailsService userDetailsService();

    void deleteEmployee(Long employeeId);
    void getAdmin(Long employeeId);
}

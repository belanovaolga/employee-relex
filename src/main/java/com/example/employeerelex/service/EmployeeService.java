package com.example.employeerelex.service;

import com.example.employeerelex.dto.IdDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService {
    UserDetailsService userDetailsService();

    void deleteEmployee(Long employeeId);
    void updateRole(IdDto idDto);
}

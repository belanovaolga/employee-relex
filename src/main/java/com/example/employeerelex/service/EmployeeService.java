package com.example.employeerelex.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService {
    UserDetailsService userDetailsService();

    void deleteEmployee(Long employeeId);
    void updateRole(Long employeeId);
}

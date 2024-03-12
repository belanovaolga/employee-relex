package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeDto;
import com.example.employeerelex.dto.EmployeeSingInDto;
import com.example.employeerelex.dto.JwtAuthenticationResponse;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.entity.Role;
import com.example.employeerelex.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override

    public EmployeeEntity createEmployee(EmployeeDto employeeEntity) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .userName(employeeEntity.getUserName())
                .password(passwordEncoder.encode(employeeEntity.getPassword()))
                .email(employeeEntity.getEmail())
                .role(Role.EMPLOYEE)
                .build();

        return employeeRepository.save(employee);
    }

    @Override
    public JwtAuthenticationResponse singIn(EmployeeSingInDto employeeSingInDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                employeeSingInDto.getUserName(),
                employeeSingInDto.getPassword()
        ));

        UserDetails userDetails = employeeService
                .userDetailsService()
                .loadUserByUsername(employeeSingInDto.getUserName());

        String jwt = jwtService.generateToken(userDetails);
        return new JwtAuthenticationResponse(jwt);
    }
}

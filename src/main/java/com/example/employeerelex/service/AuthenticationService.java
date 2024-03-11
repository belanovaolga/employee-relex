package com.example.employeerelex.service;

import com.example.employeerelex.dto.EmployeeCreateDto;
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
public class AuthenticationService {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public EmployeeEntity createEmployee(EmployeeCreateDto employeeEntity) {
        EmployeeEntity employee = EmployeeEntity.builder()
                .userName(employeeEntity.getUserName())
                .password(passwordEncoder.encode(employeeEntity.getPassword()))
                .email(employeeEntity.getEmail())
                .role(Role.ADMIN)
                .build();

        return employeeRepository.save(employee);
    }
    /*public JwtAuthenticationResponse singUp(EmployeeSingUpDto employeeSingUp) {

        EmployeeEntity employee = EmployeeEntity.builder()
                .userName(employeeSingUp.getUserName())
                .password(passwordEncoder.encode(employeeSingUp.getPassword()))
                .email(employeeSingUp.getEmail())
                .role(Role.USER)
                .build();

        employeeRepository.save(employee);

        String jwt = jwtService.generateToken(employee);
        return new JwtAuthenticationResponse(jwt);
    }*/

    /**
     * аутентификация пользователя
     * @param employeeSingInDto данные пользователя
     * @return токен
     */
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

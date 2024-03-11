package com.example.employeerelex.controller;

import com.example.employeerelex.dto.EmployeeCreateDto;
import com.example.employeerelex.dto.EmployeeSingInDto;
import com.example.employeerelex.dto.JwtAuthenticationResponse;
import com.example.employeerelex.entity.EmployeeEntity;
import com.example.employeerelex.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/createEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeEntity createEmployee(
            @RequestBody EmployeeCreateDto employeeEntity
    ) {
        return authenticationService.createEmployee(employeeEntity);
    }

    /*@PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid EmployeeSingUpDto employeeSingUp) {
        return authenticationService.singUp(employeeSingUp);
    }*/

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid EmployeeSingInDto employeeSingIn) {
        return authenticationService.singIn(employeeSingIn);
    }
}

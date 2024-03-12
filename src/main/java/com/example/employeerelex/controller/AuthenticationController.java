package com.example.employeerelex.controller;

import com.example.employeerelex.dto.EmployeeSingInDto;
import com.example.employeerelex.dto.JwtAuthenticationResponse;
import com.example.employeerelex.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    /**
     * авторизация сотрудника
     * @param employeeSingIn данные, необходимые для авторизации сотрудника(
     *      *                    имя сотрудника,
     *      *                    пароль сотрудника)
     * @return токен
     */
    @PostMapping("auth/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody EmployeeSingInDto employeeSingIn) {
        return authenticationService.singIn(employeeSingIn);
    }
}

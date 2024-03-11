package com.example.employeerelex.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * класс для авторизации сотрудника
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSingInDto {
    @Size(max = 50)
    @NotBlank
    private String userName;
    @Size(max = 255)
    @NotBlank
    private String password;
}

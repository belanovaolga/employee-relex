package com.example.employeerelex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * класс для создания нового сотрудника
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDto {
    @Size(max = 50)
    @NotBlank
    private String userName;
    @Size(max = 50)
    @NotBlank
    @Email
    private String email;
    @Size(max = 255)
    private String password;
}

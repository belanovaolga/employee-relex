package com.example.employeerelex.dto;

import lombok.*;

/**
 * класс для ввода информации для добавления в базу данных нового сотрудника
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
}

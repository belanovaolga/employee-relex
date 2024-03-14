package com.example.employeerelex.dto;

import com.example.employeerelex.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * класс для поиска сотрудника по идентификационному номеру
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdDto {
    @Size(max = 255)
    @NotBlank
    private Long employeeId;
    @Enumerated(EnumType.STRING)
    private Role role;
}

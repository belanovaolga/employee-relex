package com.example.employeerelex.dto;

import lombok.*;

/**
 * класс для получения ответа с токеном доступа
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
}


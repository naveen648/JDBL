package com.jwt.example.SpringSecurity.JWT.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JetResponse {
    private String jwtToken;
    private String username;
}

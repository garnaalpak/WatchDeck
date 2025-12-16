package io.github.garnaalpak.backend.controllers;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequest {

    private String username;

    private String password;
}

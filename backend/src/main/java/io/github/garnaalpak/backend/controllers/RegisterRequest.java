package io.github.garnaalpak.backend.controllers;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String firstname;

    private String username;

    private String email;

    private String password;

}

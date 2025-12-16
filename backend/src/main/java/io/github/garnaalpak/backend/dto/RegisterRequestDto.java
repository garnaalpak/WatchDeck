package io.github.garnaalpak.backend.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {

    private String firstname;

    private String username;

    private String email;

    private String password;

}

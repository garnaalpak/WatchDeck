package io.github.garnaalpak.backend.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequestDto {

    private String username;

    private String password;
}

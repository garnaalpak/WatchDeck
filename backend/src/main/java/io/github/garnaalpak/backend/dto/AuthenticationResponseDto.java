package io.github.garnaalpak.backend.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {

    private String token;
}

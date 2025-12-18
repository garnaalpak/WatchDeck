package io.github.garnaalpak.backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequestDto {

    @NotBlank(message = "Nazwa użytkownika jest wymagana")
    @Size(min = 3, max = 40, message = "Nazwa użytkownika musi mieć od 3 do 40 znaków")
    private String username;

    @NotBlank(message = "Hasło jest wymagane")
    private String password;
}

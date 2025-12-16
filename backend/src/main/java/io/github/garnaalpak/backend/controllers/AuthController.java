package io.github.garnaalpak.backend.controllers;

import io.github.garnaalpak.backend.dto.AuthenticateRequestDto;
import io.github.garnaalpak.backend.dto.AuthenticationResponseDto;
import io.github.garnaalpak.backend.dto.RegisterRequestDto;
import io.github.garnaalpak.backend.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
class AuthController {

    private final AuthService service;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(
            @RequestBody RegisterRequestDto request
    )
    {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> register(
            @RequestBody AuthenticateRequestDto request
    )
    {
        return ResponseEntity.ok(service.authenticate(request));
    }

}

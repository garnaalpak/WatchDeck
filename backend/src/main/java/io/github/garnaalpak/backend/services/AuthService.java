package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.AuthenticateRequestDto;
import io.github.garnaalpak.backend.dto.AuthenticationResponseDto;
import io.github.garnaalpak.backend.dto.RegisterRequestDto;
import io.github.garnaalpak.backend.exceptions.ConflictException;
import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.repositories.UserRepository;
import io.github.garnaalpak.backend.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public @Nullable AuthenticationResponseDto register(RegisterRequestDto request) {

        if (userRepository.existsByUsername(request.getUsername()) || userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("User with this username or email already exists");
        }


        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .role(roleRepository.findByName("ROLE_USER")
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found.")))
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public @Nullable AuthenticationResponseDto authenticate(AuthenticateRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();

    }
}

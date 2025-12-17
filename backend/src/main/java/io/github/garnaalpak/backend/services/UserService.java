package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.UserDto;
import io.github.garnaalpak.backend.exceptions.NotFoundException;
import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getCurrentUserDto() {
        User user = getCurrentUser();
        return UserDto.builder()
                .firstname(user.getFirstname())
                .username(user.getUsername())
                .email(user.getEmail())
                .roleName(user.getRole().getName())
                .build();
    }


    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}

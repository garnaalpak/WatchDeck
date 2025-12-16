package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserRepository roleRepository;

    @Override
    public Collection<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}

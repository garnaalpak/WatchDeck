package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class UserService implements IUserService {

    private UserRepository userRepository;
    private UserRepository roleRepository;

    public UserService(UserRepository userRepository, UserRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}

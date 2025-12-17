package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.UserDto;
import io.github.garnaalpak.backend.models.User;

import java.util.Collection;

public interface IUserService {
    Collection<User> getAllUsers();

    UserDto getCurrentUserDto();
}

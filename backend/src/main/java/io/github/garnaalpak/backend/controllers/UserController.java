package io.github.garnaalpak.backend.controllers;

import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.services.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/users/")
class UserController {

    private final IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/all")
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }
}

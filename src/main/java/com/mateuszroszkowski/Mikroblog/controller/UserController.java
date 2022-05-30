package com.mateuszroszkowski.Mikroblog.controller;

import com.mateuszroszkowski.Mikroblog.dto.UserDto;
import com.mateuszroszkowski.Mikroblog.model.User;
import com.mateuszroszkowski.Mikroblog.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @Operation(summary = "Create user", description = "Using this endpoint you can create new user in the system. User username and email" +
            " must be unique. If user with this username or emails exists in the system response contains a message about it.")
    @PostMapping("/")
    public void createUser(@RequestBody UserDto userDto) throws RuntimeException {
        userService.createUser(userDto);
    }

    @Operation(summary = "Get all users", description = "Returns all users in the system")
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

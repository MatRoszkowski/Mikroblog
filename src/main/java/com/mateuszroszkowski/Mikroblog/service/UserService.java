package com.mateuszroszkowski.Mikroblog.service;

import com.mateuszroszkowski.Mikroblog.dto.UserDto;
import com.mateuszroszkowski.Mikroblog.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<User> getAllUsers();
}

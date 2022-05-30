package com.mateuszroszkowski.Mikroblog.mapper;

import com.mateuszroszkowski.Mikroblog.dto.UserDto;
import com.mateuszroszkowski.Mikroblog.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User map(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .build();
    }

    public UserDto map(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}

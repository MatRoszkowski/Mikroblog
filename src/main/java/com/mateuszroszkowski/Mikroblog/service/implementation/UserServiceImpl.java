package com.mateuszroszkowski.Mikroblog.service.implementation;

import com.mateuszroszkowski.Mikroblog.dto.UserDto;
import com.mateuszroszkowski.Mikroblog.mapper.UserMapper;
import com.mateuszroszkowski.Mikroblog.model.User;
import com.mateuszroszkowski.Mikroblog.service.UserService;
import com.mateuszroszkowski.Mikroblog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) throws RuntimeException {
        checkIfUserWithUsernameEmailExists(userDto);
        User user = userMapper.map(userDto);
        user = userRepository.save(user);
        log.info("User successfully created");
        return userMapper.map(user);
    }

    public void checkIfUserWithUsernameEmailExists(UserDto userDto) throws RuntimeException {
        Optional<User> userByUsername = userRepository.findByUsername(userDto.getUsername());
        Optional<User> userByEmail = userRepository.findByEmail(userDto.getEmail());
        if (userByUsername.isPresent()) {
            throw new RuntimeException("User with username: " + userDto.getUsername() + " already exists");
        }
        if (userByEmail.isPresent()) {
            throw new RuntimeException("User with email: " + userDto.getEmail() + " already exists");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

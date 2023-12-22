package com.example.myup.service;

import com.example.myup.dto.UserDto;
import com.example.myup.entity.User;
import com.example.myup.mapper.UserMapper;
import com.example.myup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserDto getById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + id + " not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.toDtos(allUsers);
    }

    @Override
    public void update(String id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + id + " not found"));
        userMapper.update(existingUser, userDto);
        save(userDto);
    }

    @Override
    public void deleteById(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage());
        }
    }
}

package com.example.myup.service;

import com.example.myup.dto.UserDto;
import com.example.myup.entity.User;
import com.example.myup.mapper.UserMapper;
import com.example.myup.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserDto getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with id: " + id + " not found");
        }
        User user = optionalUser.get();
        return userMapper.toDto(user);
    }

    @Override
    public void update(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with id: " + id + " not found");
        }
        User existingUser = optionalUser.get();
        userMapper.update(existingUser, userDto);
        save(userDto);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

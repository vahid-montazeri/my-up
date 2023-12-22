package com.example.myup.service;

import com.example.myup.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);

    UserDto getById(String id);

    List<UserDto> getAll();

    void update(String id, UserDto userDto);

    void deleteById(String id);


}

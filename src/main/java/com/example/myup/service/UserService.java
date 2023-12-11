package com.example.myup.service;

import com.example.myup.dto.UserDto;

public interface UserService {

    void save(UserDto userDto);

    UserDto getById(Long id);

    void update(Long id, UserDto userDto);

    void deleteById(Long id);


}

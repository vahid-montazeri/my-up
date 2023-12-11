package com.example.myup.mapper;

import com.example.myup.dto.UserDto;
import com.example.myup.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {


}

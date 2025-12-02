package com.Khewang.blogging.service;


import com.Khewang.blogging.payload.UserDto;


import java.util.List;


public abstract interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}

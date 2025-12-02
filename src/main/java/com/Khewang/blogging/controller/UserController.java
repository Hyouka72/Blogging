package com.Khewang.blogging.controller;

import com.Khewang.blogging.payload.UserDto;
import com.Khewang.blogging.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
      UserDto createUserDto =  this.userService.createUser(userDto);
      return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
}

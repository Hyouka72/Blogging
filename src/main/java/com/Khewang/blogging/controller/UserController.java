package com.Khewang.blogging.controller;

import com.Khewang.blogging.payload.ApiResponse;
import com.Khewang.blogging.payload.UserDto;
import com.Khewang.blogging.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
      UserDto createUserDto =  this.userService.createUser(userDto);
      return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto>  updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer id){
        UserDto updatedUser = this.userService.updateUser(userDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer id){
            this.userService.deleteUser(id);
            return new ResponseEntity<>(new ApiResponse("User Deleted Sucessfully", true), HttpStatus.OK);
    }

    //Get user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable Integer id) {
        UserDto userDto = this.userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}

package com.Khewang.blogging.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min =3 , message = "Username should be min of 3 character")
    private String name;


    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 3, max = 10, message = "Password should be minimum of 4 character")
    private String password;

    @NotBlank(message = "About cannot be blank")
    private String about;

}

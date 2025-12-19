package com.Khewang.blogging.payload;

import com.Khewang.blogging.model.Category;
import com.Khewang.blogging.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    @NotBlank(message = "Title cannot be blank")
    @Size(min =3 , message = "Title should be min of 3 character")
    private String title;

    @NotBlank(message = "content cannot be blank")
    @Size(min =20 , message = "Username should be min of 20 character")
    private String content;

    private String imageName;
    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

}

package com.Khewang.blogging.payload;

import com.Khewang.blogging.model.Category;
import com.Khewang.blogging.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    private String imageName;
    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

}

package com.Khewang.blogging.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotBlank(message = "Title is required")
    // In Json use Dto value to send input not the model ones
    private String categoryName;
    @NotNull(message = "Description is required")
    private String categoryDescription;
}

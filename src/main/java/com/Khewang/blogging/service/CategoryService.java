package com.Khewang.blogging.service;

import com.Khewang.blogging.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
     CategoryDto createCategory(CategoryDto categoryDto);
    //update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
     CategoryDto getCategoryById(Integer categoryId);

    //getall
      List<CategoryDto> getAllCategories();
}

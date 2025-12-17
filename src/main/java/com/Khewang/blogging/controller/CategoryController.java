package com.Khewang.blogging.controller;

import com.Khewang.blogging.payload.ApiResponse;
import com.Khewang.blogging.payload.CategoryDto;

import com.Khewang.blogging.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    //create

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId) {

        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);

        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //delete

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer userId) {
        this.categoryService.deleteCategory(userId);
        return new ResponseEntity<>(new ApiResponse("category is deleted", true), HttpStatus.OK);
    }

    //get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId){
        CategoryDto getDto = this.categoryService.getCategoryById(catId);
        return new ResponseEntity<>(getDto, HttpStatus.OK);
    }

    //getall
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> Categories = this.categoryService.getAllCategories();
        return new ResponseEntity<>(Categories, HttpStatus.OK);

    }
}

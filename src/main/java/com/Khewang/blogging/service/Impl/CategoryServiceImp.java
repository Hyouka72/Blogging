package com.Khewang.blogging.service.Impl;

import com.Khewang.blogging.exception.ResourceNotFoundException;
import com.Khewang.blogging.model.Category;
import com.Khewang.blogging.payload.CategoryDto;
import com.Khewang.blogging.repository.CategoryRepository;
import com.Khewang.blogging.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepo = categoryRepository;
    }

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat =  this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" ,"Category Id", categoryId));
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        cat.setCategoryName(categoryDto.getCategoryName());
        Category updatedCat = this.categoryRepo.save(cat);

        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" ,"Category Id", categoryId));
        this.categoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" ,"Category Id", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> catList = this.categoryRepo.findAll();
       List<CategoryDto> collect =  catList.stream().map(cat -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return collect;
    }


}

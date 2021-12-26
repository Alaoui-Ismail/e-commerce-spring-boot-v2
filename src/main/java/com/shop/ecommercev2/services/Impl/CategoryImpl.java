package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.entities.Category;

import com.shop.ecommercev2.entities.ParentCategory;
import com.shop.ecommercev2.repositories.CategoryRepository;

import com.shop.ecommercev2.repositories.ParentCategoryRepository;
import com.shop.ecommercev2.services.ICategoryService;
import com.shop.ecommercev2.shared.dto.CategoryDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ParentCategoryRepository parentCategoryRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.findByName(categoryDto.getName());

        ParentCategory parentCategory = parentCategoryRepository.findById(categoryDto.getParent_id()).orElse(null);


        if (category != null) throw new RuntimeException("parent category already exists !");

        Category new_category = new Category();
        BeanUtils.copyProperties(categoryDto, new_category);

        new_category.setParentCategory(parentCategory);

        System.out.println("categorie servce "+ categoryDto);

        System.out.println("categorie servce 2"+ new_category);

        Category Category1 = categoryRepository.save(new_category);
        CategoryDto new_CategoryDto = new CategoryDto();

        BeanUtils.copyProperties(Category1, new_CategoryDto);


        return new_CategoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        return null;
    }

    @Override
    public void deleteCategory(CategoryDto categoryDto) {

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto findCategoryById(Long id) {
        return null;
    }
}

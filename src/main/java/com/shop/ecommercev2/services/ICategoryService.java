package com.shop.ecommercev2.services;

import com.shop.ecommercev2.shared.dto.CategoryDto;


import java.util.List;

public interface ICategoryService {



    CategoryDto saveCategory(CategoryDto categoryDto );


    CategoryDto updateCategory( CategoryDto categoryDto,Long id );


    void deleteCategory(CategoryDto categoryDto );


    List<CategoryDto> getAllCategories();


    CategoryDto findCategoryById(Long id);

}

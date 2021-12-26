package com.shop.ecommercev2.services;

import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import java.util.List;
import java.util.Optional;

public interface IParentCategoryService {

    //save parentCategory
    ParentCategoryDto saveParentCategory( ParentCategoryDto parentCategoryDto );

    //update parentCategory
    ParentCategoryDto updateParentCategory( ParentCategoryDto parentCategoryDto,Long id );

    //delete parentCategory
    void deleteParentCategory(ParentCategoryDto parentCategoryDto );

    //get All parentCategory
    List<ParentCategoryDto> getAllParentCategories();

    //get parentCategory By Id
    ParentCategoryDto findParentCategoryById(Long id);



}

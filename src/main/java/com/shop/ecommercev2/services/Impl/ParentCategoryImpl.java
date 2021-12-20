package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.entities.ParentCategory;
import com.shop.ecommercev2.repositories.ParentCategoryRepository;
import com.shop.ecommercev2.services.IParentCategoryService;
import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParentCategoryImpl implements IParentCategoryService {

    @Autowired
    ParentCategoryRepository parentCategoryRepository;


    @Override
    public ParentCategoryDto saveParentCategory(ParentCategoryDto parentCategoryDto) {

        ParentCategory parentCategory = parentCategoryRepository.findByName(parentCategoryDto.getParentCategoryName());

        if (parentCategory != null) throw new RuntimeException("parent category already exists !");

        ParentCategory new_parent_category = new ParentCategory();
        BeanUtils.copyProperties(parentCategoryDto, new_parent_category);

        ParentCategory parentCategory1 = parentCategoryRepository.save(new_parent_category);
        ParentCategoryDto new_ParentCategoryDto = new ParentCategoryDto();

        BeanUtils.copyProperties(parentCategory1, new_ParentCategoryDto);


        return new_ParentCategoryDto;
    }

    @Override
    public ParentCategoryDto updateParentCategory(ParentCategoryDto parentCategoryDto) {
        ParentCategory parentCategory = parentCategoryRepository.findByName(parentCategoryDto.getParentCategoryName());

        if (parentCategory == null) throw new RuntimeException("parent category does not exists !");

        ParentCategory new_parent_category = new ParentCategory();
        BeanUtils.copyProperties(parentCategoryDto, new_parent_category);

        ParentCategory parentCategory1 = parentCategoryRepository.save(new_parent_category);
        ParentCategoryDto new_ParentCategoryDto = new ParentCategoryDto();

        BeanUtils.copyProperties(parentCategory1, new_ParentCategoryDto);


        return new_ParentCategoryDto;
    }

    @Override
    public void deleteParentCategory(ParentCategoryDto parentCategoryDto) {

        if (parentCategoryRepository.findById(parentCategoryDto.getParentCategoryId()) == null)
            throw new RuntimeException("parent category does not exists !");

        ParentCategory parentCategory = new ParentCategory();
        BeanUtils.copyProperties(parentCategoryDto, parentCategory);

        parentCategoryRepository.delete(parentCategory);


    }

    @Override
    public List<ParentCategoryDto> getAllParentCategories() {

        List<ParentCategory> parentCategoryList = parentCategoryRepository.findAll();

        List<ParentCategoryDto> parentCategoryDtoList = new ArrayList<>();
        BeanUtils.copyProperties(parentCategoryList, parentCategoryDtoList);

        return parentCategoryDtoList;
    }

    @Override
    public ParentCategoryDto findParentCategoryById(Long id) {

        ParentCategoryDto parentCategoryDto = new ParentCategoryDto();
        BeanUtils.copyProperties(parentCategoryRepository.findById(id),parentCategoryDto);

        return parentCategoryDto;
    }
}

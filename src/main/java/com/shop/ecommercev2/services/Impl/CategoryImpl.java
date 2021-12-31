package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.entities.Category;

import com.shop.ecommercev2.entities.ParentCategory;
import com.shop.ecommercev2.repositories.CategoryRepository;

import com.shop.ecommercev2.repositories.ParentCategoryRepository;
import com.shop.ecommercev2.services.ICategoryService;
import com.shop.ecommercev2.shared.dto.CategoryDto;

import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        System.out.println("categorie servce " + categoryDto);

        System.out.println("categorie servce 2" + new_category);

        Category Category1 = categoryRepository.save(new_category);
        CategoryDto new_CategoryDto = new CategoryDto();

        BeanUtils.copyProperties(Category1, new_CategoryDto);


        return new_CategoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {


        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null) throw new RuntimeException(" category does not exists !");

        Category new_category = new Category(categoryDto.getName(), categoryDto.getDescription(), categoryDto.getArticles(), categoryDto.getParentCategory1(),categoryDto.getParent_id());
        //BeanUtils.copyProperties(categoryDto, new_category);
        new_category.setCategoryId(id);
        new_category.setParentCategory(category.getParentCategory());
        Category category1 = categoryRepository.save(new_category);
        CategoryDto new_CategoryDto = new CategoryDto();


        BeanUtils.copyProperties(category1, new_CategoryDto);


        return new_CategoryDto;

    }

    @Override
    public void deleteCategory(CategoryDto categoryDto) {


      if(categoryRepository.findById(categoryDto.getCategoryId())==null) throw
              new RuntimeException(" category does not exists !");

        Category category = new Category();
        //Vo a Bo
        BeanUtils.copyProperties(categoryDto, category);

        categoryRepository.delete(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {


        List<Category> categoryList = categoryRepository.findAll();


        System.out.println("impl ");
        List<CategoryDto> categoryDtoList = new ArrayList<>();


      //  categoryDtoList = modelMapper.map(categoryList, new TypeToken<List<CategoryDto>>() {
       // }.getType());
        for(Category c: categoryList){
           CategoryDto catDto =new CategoryDto(c.getName(), c.getDescription(), c.getParent_id(), c.getArticles(), c.getParentCategory());
           catDto.setCategoryId(c.getCategoryId());
           categoryDtoList.add(catDto);
            System.out.println("okeeeee new list " +catDto.getName()+" "+ catDto.getParentCategory1().getName());
        }

       /* for(CategoryDto c: categoryDtoList){
            System.out.println("okeeeee 2 2 " +c.getName()+" "+ c.getParent_id())
            ;

            ParentCategory p = parentCategoryRepository.findById(c.getParent_id()).orElse(null);
            System.out.println("new sys "+ p.getName());
        }

        */


        return categoryDtoList;
    }

    @Override
    public CategoryDto findCategoryById(Long id) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(categoryRepository.findById(id).orElse(null), categoryDto);

        return categoryDto;
    }
}

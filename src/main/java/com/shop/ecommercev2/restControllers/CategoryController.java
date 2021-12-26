package com.shop.ecommercev2.restControllers;

import com.shop.ecommercev2.repositories.CategoryRepository;
import com.shop.ecommercev2.services.Impl.CategoryImpl;
import com.shop.ecommercev2.shared.dto.CategoryDto;
import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryImpl categoryImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto) {


        categoryImpl.saveCategory(categoryDto);

        return new ResponseEntity<String>("added successfully", HttpStatus.CREATED);
    }
}

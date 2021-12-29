package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.entities.ParentCategory;
import com.shop.ecommercev2.services.Impl.ParentCategoryImpl;
import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentCategoryController {


    @Autowired
    ParentCategoryImpl parentCategoryImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addParentCategory(@RequestBody ParentCategoryDto parentCategoryDto) {

        parentCategoryImpl.saveParentCategory(parentCategoryDto);


        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ParentCategoryDto>> getAll() {


        return new ResponseEntity<>(parentCategoryImpl.getAllParentCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{parentCategoryId}")

    public ResponseEntity getParentCategory(@PathVariable("parentCategoryId") Long parentCategoryId) {

        System.out.println("id " + parentCategoryId);
        ParentCategoryDto parentCategoryDto = parentCategoryImpl.findParentCategoryById(parentCategoryId);
        System.out.println("object " + parentCategoryDto.toString());
        return new ResponseEntity<>(parentCategoryDto, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{parentCategoryId}")

    public ResponseEntity deleteParentCategory(@PathVariable("parentCategoryId") Long parentCategoryId) {

        System.out.println("id " + parentCategoryId);
        ParentCategoryDto parentCategoryDto = parentCategoryImpl.findParentCategoryById(parentCategoryId);
        if (parentCategoryDto == null)
            return null;
        parentCategoryImpl.deleteParentCategory(parentCategoryDto);


        return new ResponseEntity<>("deleted with success ", HttpStatus.OK);

    }

    @PutMapping("/update/{parentCategoryId}")
    public ResponseEntity<String> updateParentCategory(@RequestBody ParentCategoryDto parentCategoryDto, @PathVariable("parentCategoryId") Long parentCategoryId) {

        ParentCategoryDto parentCategoryDto_new = parentCategoryImpl.findParentCategoryById(parentCategoryId);
        System.out.println("id of parentCategory "+ parentCategoryDto.toString());

        System.out.println("id of parentCategory 2 "+ parentCategoryDto_new.toString());



        parentCategoryImpl.updateParentCategory(parentCategoryDto,parentCategoryId);

        return new ResponseEntity<String>("Modified successfully", HttpStatus.OK);
    }


}

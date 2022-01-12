package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.entities.Category;
import com.shop.ecommercev2.repositories.CategoryRepository;
import com.shop.ecommercev2.services.Impl.CategoryImpl;
import com.shop.ecommercev2.shared.dto.CategoryDto;
import com.shop.ecommercev2.shared.dto.ParentCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryImpl categoryImpl;


    private CategoryRepository categoryRepository;

    CategoryController(CategoryRepository categoryRepository1){
        this.categoryRepository = categoryRepository1;
    }
    @GetMapping("/getAll")
    public List<CategoryDto> getAllCategories() {


        for (CategoryDto c : categoryImpl.getAllCategories()) {
            System.out.println("controller All ..... " + c.getName());
        }


        System.out.println("break");
        return categoryImpl.getAllCategories();


    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto) {


        categoryImpl.saveCategory(categoryDto);

        return new ResponseEntity<String>("added successfully", HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateParentCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") Long categoryId) {

        CategoryDto categoryDto_new = categoryImpl.findCategoryById(categoryId);
        System.out.println("id of parentCategory " + categoryDto.toString());

        System.out.println("id of parentCategory 2 " + categoryDto_new.toString());


        categoryImpl.updateCategory(categoryDto, categoryId);

        return new ResponseEntity<String>("Modified successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")

    public ResponseEntity deleteCategory(@PathVariable("id") Long id) {

        System.out.println("id " + id);
        CategoryDto categoryDto = categoryImpl.findCategoryById(id);
        // System.out.println("id 2 "+categoryDto.getCategoryId());


        if (categoryDto == null) {
            throw
                    new RuntimeException(" category does not exists !");
        }

        categoryImpl.deleteCategory(categoryDto);

        System.out.println("okeeee ");
        return new ResponseEntity<>("deleted with success ", HttpStatus.OK);

    }


    @GetMapping(path="/imageCategory/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable(name="id") Long id) throws Exception{
        Category cat = categoryRepository.findById(id).get();
        System.out.println(cat);
       return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecommerce/categories/"+cat.getNameImage()));
        //return Files.readAllBytes(Paths.get("D:/ecommerce/categories/"+cat.getNameImage()));
    }



    @GetMapping("/getByParent/{id}")
    public ResponseEntity<List<CategoryDto>> findCategoryByParentId(
            @PathVariable("id") Long parentId) {
        List<CategoryDto> categories = categoryImpl.findCategoryByParentId(parentId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}

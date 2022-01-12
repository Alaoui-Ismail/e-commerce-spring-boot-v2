package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.Category;

import com.shop.ecommercev2.entities.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName (String name);

    List<Category> findByParentCategory(ParentCategory parentCategory);
}

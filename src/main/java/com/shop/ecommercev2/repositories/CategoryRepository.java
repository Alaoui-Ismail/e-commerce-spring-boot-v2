package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName (String name);
}

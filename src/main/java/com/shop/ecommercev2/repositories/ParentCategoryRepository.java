package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory,Long> {

    ParentCategory findByName (String name);
}

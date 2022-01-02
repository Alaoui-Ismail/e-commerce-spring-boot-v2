package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.CommandArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommandRepository extends JpaRepository<CommandArticle,Long> {
}

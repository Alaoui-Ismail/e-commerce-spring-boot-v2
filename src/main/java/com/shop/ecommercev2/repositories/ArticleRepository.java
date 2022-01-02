package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findByArticleName(String articleName);
    Article findByArticleId(Long articleName);
}

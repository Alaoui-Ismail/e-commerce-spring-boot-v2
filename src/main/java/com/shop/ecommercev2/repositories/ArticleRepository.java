package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findByArticleName(String articleName);
    Article findByArticleId(Long articleName);
    List<Article> findByCategory(Category category);
}

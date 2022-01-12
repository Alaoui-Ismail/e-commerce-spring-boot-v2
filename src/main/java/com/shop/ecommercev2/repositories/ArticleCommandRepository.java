package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.CommandArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommandRepository extends JpaRepository<CommandArticle,Long> {


    @Query(nativeQuery = true,value = "SELECT * FROM command_article WHERE command_id=:id")
    List<CommandArticle> findByCommandId(@Param("id") Long id);
}


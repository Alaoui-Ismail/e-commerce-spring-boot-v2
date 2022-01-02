package com.shop.ecommercev2.services;

import com.shop.ecommercev2.shared.dto.ArticleDto;
import java.util.List;
public interface IArticleService {


     ArticleDto addArticle(ArticleDto articleDto);

     ArticleDto updateArticle(Long idArticle, ArticleDto article);

     void deleteArticle(Long idArticle);

     List<ArticleDto> getAll();
}

package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.entities.Category;
import com.shop.ecommercev2.repositories.ArticleRepository;
import com.shop.ecommercev2.repositories.CategoryRepository;
import com.shop.ecommercev2.services.IArticleService;
import com.shop.ecommercev2.shared.dto.ArticleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleImpl implements IArticleService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public ArticleDto addArticle(ArticleDto articleDto) {
        Article articleVerify = articleRepository.findByArticleName(articleDto.getArticleName());
        if (articleVerify != null)
            throw new RuntimeException("Article already exists!!");

        // convert dto to entity

        Article articleRequest = modelMapper.map(articleDto, Article.class);

        Category category = categoryRepository.findById(articleDto.getCategoryId()).orElse(null);

        System.out.println("id "+  category.getCategoryId());
        articleRequest.setCategory(category);

        Article article = articleRepository.save(articleRequest);

        // convert entity to dto

        ArticleDto articleResponse = modelMapper.map(article, ArticleDto.class);

        return articleResponse;
    }

    @Override
    public ArticleDto updateArticle(Long idArticle, ArticleDto articleDto) {
        // Check if article exists or not

        Article searchArticle = articleRepository.findByArticleId(idArticle);

        if (searchArticle == null)
            throw new RuntimeException("Article does not exist");

        // convert DTO to entity

        Article articleRequest = modelMapper.map(articleDto, Article.class);

        articleRequest.setArticleId(idArticle);
        articleRequest.setArticleName(articleDto.getArticleName());
        articleRequest.setArticleDescription(articleDto.getArticleDescription());
        articleRequest.setArticleQuantity(articleDto.getArticleQuantity());

        Article articleAdded = articleRepository.save(articleRequest);

        // convert entity to DTO

        ArticleDto articleResponse = modelMapper.map(articleAdded, ArticleDto.class);

        return articleResponse;
    }

    @Override
    public void deleteArticle(Long idArticle) {
        Article searchArticle = articleRepository.findByArticleId(idArticle);

        if (searchArticle == null) {
            throw new RuntimeException("Article doesn't exist. It can't be deleted ...");
        }

        else {
            articleRepository.delete(searchArticle);
        }
    }

    @Override
    public List<ArticleDto> getAll() {
        System.out.println("new article" + articleRepository.findAll());
        return articleRepository.findAll().stream().map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toList());
    }
}

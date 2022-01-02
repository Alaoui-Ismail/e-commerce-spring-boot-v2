package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.services.IArticleService;
import com.shop.ecommercev2.shared.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/articles")
public class ArticleController {


    @Autowired
    IArticleService articleservice;

    @PostMapping("/add")
    public ResponseEntity<String> addArticle(@RequestBody ArticleDto articleDto) {
        articleservice.addArticle(articleDto);
        return new ResponseEntity<String>("New article has been added successfully!", HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ArticleDto>> getAll() {
        List<ArticleDto> listOfArticles = articleservice.getAll();
        return new ResponseEntity<List<ArticleDto>>(listOfArticles, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable("id") Long idArticle,@RequestBody ArticleDto articleDto){

        ArticleDto update = articleservice.updateArticle(idArticle, articleDto);
        return new ResponseEntity<ArticleDto>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long idArticle){
        articleservice.deleteArticle(idArticle);
        return new ResponseEntity<String>("Article has been deleted successfully", HttpStatus.OK);
    }



}


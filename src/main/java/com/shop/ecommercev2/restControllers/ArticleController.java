package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.repositories.ArticleRepository;
import com.shop.ecommercev2.services.IArticleService;
import com.shop.ecommercev2.shared.dto.ArticleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

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
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable("id") Long idArticle, @RequestBody ArticleDto articleDto) {

        ArticleDto update = articleservice.updateArticle(idArticle, articleDto);
        return new ResponseEntity<ArticleDto>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long idArticle) {
        articleservice.deleteArticle(idArticle);
        return new ResponseEntity<String>("Article has been deleted successfully", HttpStatus.OK);
    }


    @GetMapping(path = "/imageArticle/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable("id") Long id) throws Exception {
        Article article = articleRepository.findById(id).orElse(null);
        System.out.println("image loading by id" + " " + article.getArticleId());
        byte[] imageByte = Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecommerce/products/"+article.getImageName()));
        return imageByte;

    }

    @GetMapping("/getByCategory/{id}")
    public ResponseEntity<List<ArticleDto>> findCategoryByParentId(
            @PathVariable("id") Long catId) {
        List<ArticleDto> articles = articleservice.findArticleyByCategoryId(catId);
        System.out.println(articles);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }


}


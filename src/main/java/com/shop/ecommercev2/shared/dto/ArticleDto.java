package com.shop.ecommercev2.shared.dto;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.ecommercev2.entities.Category;
import com.shop.ecommercev2.entities.Command;
import com.shop.ecommercev2.entities.Evaluation;

public class ArticleDto implements Serializable {

    private Long articleId;
    private String articleName;
    private String articleDescription;
    private double articlePrice;
    private int articleQuantity;

    private List<Command> commands;

    @JsonIgnore
    private Category category;

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    private List<Evaluation> evaluations;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public int getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }


    public ArticleDto(String articleName, String articleDescription,
                      double articlePrice, int articleQuantity,
                      List<Command> commands, Category category,
                      Long categoryId, List<Evaluation> evaluations) {
        this.articleName = articleName;
        this.articleDescription = articleDescription;
        this.articlePrice = articlePrice;
        this.articleQuantity = articleQuantity;
        this.commands = commands;
        this.category = category;
        this.categoryId = categoryId;
        this.evaluations = evaluations;
    }

    public ArticleDto() {}



}

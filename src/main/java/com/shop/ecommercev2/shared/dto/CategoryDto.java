package com.shop.ecommercev2.shared.dto;

import com.shop.ecommercev2.entities.Article;
import com.shop.ecommercev2.entities.ParentCategory;
import java.util.List;

public class CategoryDto {



    private Long categoryId;
    private String name;
    private String description;

    private Long parent_id;

    private List<Article> articles ;




    public CategoryDto(){}

    public CategoryDto(String name, String description, List<Article> articles) {
        this.name = name;
        this.description = description;
        this.articles = articles;

    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Article> getArticles() {
        return articles;
    }




    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent_id=" + parent_id +
                ", articles=" + articles +
                '}';
    }
}

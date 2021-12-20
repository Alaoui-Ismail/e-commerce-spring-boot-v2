package com.shop.ecommercev2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<Article> articles ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentCategoryId")
    private ParentCategory parentCategory;


    public Category(){}

    public Category(String categoryName, String categoryDescription, List<Article> articles, ParentCategory parentCategory) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.articles = articles;
        this.parentCategory = parentCategory;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
}

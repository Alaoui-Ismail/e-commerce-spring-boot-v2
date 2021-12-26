package com.shop.ecommercev2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Article> articles ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentCategoryId")
    private ParentCategory parentCategory;


    public Category(){}

    public Category(String name, String description, List<Article> articles, ParentCategory parentCategory) {
        this.name = name;
        this.description = description;
        this.articles = articles;
        this.parentCategory = parentCategory;
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

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", articles=" + articles +
                ", parentCategory=" + parentCategory +
                '}';
    }
}

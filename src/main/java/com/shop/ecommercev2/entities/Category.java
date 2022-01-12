package com.shop.ecommercev2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    private String description;
    private String nameImage;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Article> articles ;




    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentCategoryId")
    @JsonIgnore
    private ParentCategory parentCategory;



    @JsonIgnore
    private Long parent_id;

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }


    public Category(){}

    public Category(String name, String description, String nameImage, List<Article> articles, ParentCategory parentCategory, Long parent_id) {
        this.name = name;
        this.description = description;
        this.nameImage = nameImage;
        this.articles = articles;
        this.parentCategory = parentCategory;
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

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}

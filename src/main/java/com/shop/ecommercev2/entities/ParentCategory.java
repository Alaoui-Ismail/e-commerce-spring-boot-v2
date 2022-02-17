package com.shop.ecommercev2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentCategoryId;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "parentCategory")
    private List<Category> categories;


    public ParentCategory() {
    }

    public ParentCategory(String name, String description, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}

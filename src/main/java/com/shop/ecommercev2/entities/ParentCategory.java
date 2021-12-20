package com.shop.ecommercev2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentCategoryId;
    private String name;
    private String parentCategoryDescription;


    @OneToMany(mappedBy = "parentCategory")
    private List<Category> categories;

    public ParentCategory(){}

    public ParentCategory(String parentCategoryName, String parentCategoryDescription, List<Category> categories) {
        this.name = parentCategoryName;
        this.parentCategoryDescription = parentCategoryDescription;
        this.categories = categories;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryName() {
        return name;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.name = parentCategoryName;
    }

    public String getParentCategoryDescription() {
        return parentCategoryDescription;
    }

    public void setParentCategoryDescription(String parentCategoryDescription) {
        this.parentCategoryDescription = parentCategoryDescription;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

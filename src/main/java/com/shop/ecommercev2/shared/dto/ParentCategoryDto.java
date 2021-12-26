package com.shop.ecommercev2.shared.dto;

public class ParentCategoryDto {


    private Long parentCategoryId;
    private String name;
    private String description;





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

    public ParentCategoryDto(){}

    public ParentCategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ParentCategoryDto{" +
                "parentCategoryId=" + parentCategoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

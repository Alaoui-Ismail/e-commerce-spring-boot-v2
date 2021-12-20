package com.shop.ecommercev2.shared.dto;

public class ParentCategoryDto {


    private Long parentCategoryId;
    private String parentCategoryName;
    private String parentCategoryDescription;


    public ParentCategoryDto(){}



    public ParentCategoryDto(String parentCategoryName, String parentCategoryDescription) {
        this.parentCategoryName = parentCategoryName;
        this.parentCategoryDescription = parentCategoryDescription;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public String getParentCategoryDescription() {
        return parentCategoryDescription;
    }

    public void setParentCategoryDescription(String parentCategoryDescription) {
        this.parentCategoryDescription = parentCategoryDescription;
    }
}

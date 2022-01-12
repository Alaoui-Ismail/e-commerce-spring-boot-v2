package com.shop.ecommercev2.responses;

public enum ErrorMesage {


    MISSING_REQUIRED_FIELD("Missing required field"),
    RECORD_ALREADY_EXISTS("Record Already exists"),
    INTERNAL_SERVER_ERROR("Internal E-commerce server error"),
    NO_RECORD_FOUND ("Record with ");


    private String  errorMessage;

    ErrorMesage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

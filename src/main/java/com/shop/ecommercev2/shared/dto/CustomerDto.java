package com.shop.ecommercev2.shared.dto;

public class CustomerDto extends UserDto{



    private String customerCity;
    private String customerPhone;

    public CustomerDto(){}

    public CustomerDto( String customerCity, String customerPhone) {

        this.customerCity = customerCity;
        this.customerPhone = customerPhone;
    }





    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}

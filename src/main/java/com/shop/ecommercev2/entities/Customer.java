package com.shop.ecommercev2.entities;

import javax.persistence.Entity;

@Entity
public class Customer  extends User{




    private String customerCity;
    private String customerPhone;

    public Customer(){}

    public Customer( String customerCity, String customerPhone) {

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

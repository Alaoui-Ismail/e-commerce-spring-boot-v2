package com.shop.ecommercev2.shared.dto;

import com.shop.ecommercev2.entities.Customer;

import java.util.Date;

public class CommandDto {


    private Long commandId;
    private Date commandDate;
    private double commandTotal;
    private Customer customer;

    private Boolean isValid;


    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(Date commandDate) {
        this.commandDate = commandDate;
    }

    public double getCommandTotal() {
        return commandTotal;
    }

    public void setCommandTotal(double commandTotal) {
        this.commandTotal = commandTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public CommandDto() {
    }

    public CommandDto(Date commandDate, double commandTotal, Customer customer, Boolean isValid) {
        this.commandDate = commandDate;
        this.commandTotal = commandTotal;
        this.customer = customer;
        this.isValid = isValid;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}

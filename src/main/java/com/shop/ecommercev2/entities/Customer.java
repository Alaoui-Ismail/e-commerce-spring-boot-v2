package com.shop.ecommercev2.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer  extends User{




    private String customerCity;
    private String customerPhone;

    @OneToMany(mappedBy = "customer")
    private List<Command> commands;


    public Customer(){}


    public Customer( String customerCity, String customerPhone, List<Command> commands) {

        this.customerCity = customerCity;
        this.customerPhone = customerPhone;
        this.commands = commands;
    }


    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerCity='" + customerCity + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", commands=" + commands +
                '}';
    }
}

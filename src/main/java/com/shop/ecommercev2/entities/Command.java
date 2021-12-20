package com.shop.ecommercev2.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandId;
    private Date commandDate;
    private double commandTotal;

    @ManyToMany
    @JoinTable(name = "productCommand",
            joinColumns = @JoinColumn(name = "commandId"),
            inverseJoinColumns = @JoinColumn(name = "articleId"))
    private List<Article> articles;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

}

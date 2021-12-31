package com.shop.ecommercev2.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    private String articleDescription;
    private double articlePrice;
    private int articleQuantity;

    @ManyToMany
    @JoinTable(name = "productCommand",
            joinColumns = @JoinColumn(name = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "commandId"))
    private List<Command> commands;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;


    @OneToMany(mappedBy = "article")
    private List<Evaluation> evaluations;





}

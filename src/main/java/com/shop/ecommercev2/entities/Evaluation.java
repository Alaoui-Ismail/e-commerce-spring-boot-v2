package com.shop.ecommercev2.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluationId;

    private String evaluationComment;
    private Date evaluationDate;
    private int evaluationLike;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;
}

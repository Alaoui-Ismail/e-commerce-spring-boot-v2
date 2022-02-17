package com.shop.ecommercev2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL)
    private Set<CommandArticle> commandArticleSet;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


    private int client_id;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    private Boolean isValid = false;

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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<CommandArticle> getCommandArticleSet() {
        return commandArticleSet;
    }

    public void setCommandArticleSet(Set<CommandArticle> commandArticleSet) {
        this.commandArticleSet = commandArticleSet;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }


    public Command() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Command(Date commandDate, double commandTotal,
                   List<Article> articles, Payment payment,
                   Set<CommandArticle> commandArticleSet,
                   Customer customer, Boolean isValid, int client_id) {
        this.commandDate = commandDate;
        this.commandTotal = commandTotal;
        this.articles = articles;
        this.payment = payment;
        this.commandArticleSet = commandArticleSet;
        this.customer = customer;
        this.isValid = isValid;
        this.client_id = client_id;
    }
}

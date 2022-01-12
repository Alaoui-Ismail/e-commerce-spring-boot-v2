package com.shop.ecommercev2.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    private String articleDescription;
    private double articlePrice;
    private int articleQuantity;
    private String imageName;

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

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<CommandArticle> commandArticleSet;


    public Article() {
    }


    public Set<CommandArticle> getCommandArticleSet() {
        return commandArticleSet;
    }

    public void setCommandArticleSet(Set<CommandArticle> commandArticleSet) {
        this.commandArticleSet = commandArticleSet;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public int getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Article(String articleName, String articleDescription,
                   double articlePrice, int articleQuantity,
                   String imageName, List<Command> commands,
                   Category category, List<Evaluation> evaluations,
                   Set<CommandArticle> commandArticleSet) {
        this.articleName = articleName;
        this.articleDescription = articleDescription;
        this.articlePrice = articlePrice;
        this.articleQuantity = articleQuantity;
        this.imageName = imageName;
        this.commands = commands;
        this.category = category;
        this.evaluations = evaluations;
        this.commandArticleSet = commandArticleSet;
    }
}

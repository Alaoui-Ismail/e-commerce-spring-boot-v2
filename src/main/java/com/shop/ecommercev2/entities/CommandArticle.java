package com.shop.ecommercev2.entities;


import javax.persistence.*;

@Entity
@Table(name = "command_article")
public class CommandArticle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "command_id")
    private Command command;


    private int ArticleQuantity;


    @Override
    public String toString() {
        return "CommandArticle{" +
                "id=" + id +
                ", article=" + article +
                ", command=" + command +
                ", ArticleQuantity=" + ArticleQuantity +
                '}';
    }

    public CommandArticle() {

    }

    public CommandArticle(Article article, Command command, int articleQuantity) {
        this.article = article;
        this.command = command;
        ArticleQuantity = articleQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getArticleQuantity() {
        return ArticleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        ArticleQuantity = articleQuantity;
    }
}

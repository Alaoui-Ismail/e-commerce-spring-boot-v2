package com.shop.ecommercev2.shared.dto;


public class ArticleCommandDTO {

    private Long id;


    private Long article_id;

    private Long command_id;

    private int articleQte;


    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public Long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Long command_id) {
        this.command_id = command_id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getArticleQte() {
        return articleQte;
    }

    public void setArticleQte(int articleQte) {
        this.articleQte = articleQte;
    }

    public ArticleCommandDTO() {
    }

    public ArticleCommandDTO(Long article_id, Long command_id, int articleQuantity) {
        this.article_id = article_id;
        this.command_id = command_id;
        this.articleQte = articleQuantity;
    }


    @Override
    public String toString() {
        return "ArticleCommandDTO{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", command_id=" + command_id +
                ", ArticleQuantity=" + articleQte +
                '}';
    }
}

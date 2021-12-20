package com.shop.ecommercev2.entities;

import javax.persistence.*;

@MappedSuperclass
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;


    private String userEncryptedPassword;

    private String userEmailVerificationToken;
    private Boolean userEmailVerificationStatus = false;


    public User(){}

    public User(String userFirstName, String userLastName, String userEmail, String userEncryptedPassword, String userEmailVerificationToken, Boolean userEmailVerificationStatus) {
        this.firstname = userFirstName;
        this.lastname = userLastName;
        this.email = userEmail;
       // this.userPassword = userPassword;
        this.userEncryptedPassword = userEncryptedPassword;
        this.userEmailVerificationToken = userEmailVerificationToken;
        this.userEmailVerificationStatus = userEmailVerificationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

    public String getUserEncryptedPassword() {
        return userEncryptedPassword;
    }

    public void setUserEncryptedPassword(String userEncryptedPassword) {
        this.userEncryptedPassword = userEncryptedPassword;
    }

    public String getUserEmailVerificationToken() {
        return userEmailVerificationToken;
    }

    public void setUserEmailVerificationToken(String userEmailVerificationToken) {
        this.userEmailVerificationToken = userEmailVerificationToken;
    }

    public Boolean getUserEmailVerificationStatus() {
        return userEmailVerificationStatus;
    }

    public void setUserEmailVerificationStatus(Boolean userEmailVerificationStatus) {
        this.userEmailVerificationStatus = userEmailVerificationStatus;
    }
}

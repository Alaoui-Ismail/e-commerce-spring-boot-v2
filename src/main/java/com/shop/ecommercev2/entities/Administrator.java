package com.shop.ecommercev2.entities;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

    private boolean isEnabled;


    public Administrator() {

    }

    public Administrator(String userFirstName, String userLastName, String userEmail, String userPassword, String userEncryptedPassword, String userEmailVerificationToken, Boolean userEmailVerificationStatus, boolean isEnabled) {
        super(userFirstName, userLastName, userEmail, userEncryptedPassword, userEmailVerificationToken, userEmailVerificationStatus);
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}

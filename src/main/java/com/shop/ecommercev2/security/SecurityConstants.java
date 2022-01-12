package com.shop.ecommercev2.security;

public class SecurityConstants {

    public static final long EXPIRATION_TIME =  864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/*";
    public static final String TOKEN_SECRET = "dfg893hdc475zwerop4tghg4ddfdfgdsdfeqaas?=-0ljznm0-9";

    //token se constitue de 3 parties :
     /*
     -header
     -payload
     -signature : doit contenir une cle secrete , la derniere ca aide spring a lire le token
      */
}

package com.shop.ecommercev2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ECommerceV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceV2Application.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean

    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

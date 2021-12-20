package com.shop.ecommercev2.services;

import com.shop.ecommercev2.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {


    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);
}

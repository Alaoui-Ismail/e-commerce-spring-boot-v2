package com.shop.ecommercev2.services;

import com.shop.ecommercev2.entities.Customer;
import com.shop.ecommercev2.entities.User;
import com.shop.ecommercev2.shared.dto.CustomerDto;
import com.shop.ecommercev2.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface IUserService extends UserDetailsService {


    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);
    List<CustomerDto> getAll ();
    CustomerDto updateUser(Long id, CustomerDto customer);

}

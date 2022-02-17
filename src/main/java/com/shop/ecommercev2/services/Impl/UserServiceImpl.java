package com.shop.ecommercev2.services.Impl;

import com.shop.ecommercev2.Utils.Utils;
import com.shop.ecommercev2.entities.Customer;
import com.shop.ecommercev2.repositories.UserRepository;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.CustomerDto;
import com.shop.ecommercev2.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ModelMapper modelMapper;


    private IUserService iUserService;

    @Autowired
    public UserServiceImpl(@Lazy IUserService iUserService) {
        this.iUserService = iUserService;
    }


    @Override
    public UserDto createUser(UserDto userDto) {

        Customer checkCustomer = userRepository.findByEmail(userDto.getEmail());
        if (checkCustomer != null) throw new RuntimeException("User Already Exists !");

        Customer customer = new Customer();
        BeanUtils.copyProperties(userDto, customer);

        customer.setUserEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        customer.setUserId(utils.generateStringId(32));

        Customer new_user = userRepository.save(customer);

        UserDto userDto1 = new UserDto();
        BeanUtils.copyProperties(new_user, userDto1);

        return userDto1;
    }

    @Override
    public UserDto getUser(String email) {
        Customer customer = userRepository.findByEmail(email);
        if (customer == null) throw new UsernameNotFoundException(email);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(customer, userDto);

        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Customer customer = userRepository.findByEmail(email);
        if (customer == null) throw new UsernameNotFoundException(email);

        return new User(customer.getUserEmail(), customer.getUserEncryptedPassword(), new ArrayList<>());
    }


    @Override
    public List<CustomerDto> getAll() {
        Iterable<Customer> usersList = userRepository.findAll();
        Type usersDtoList = new TypeToken<List<CustomerDto>>() {
        }.getType();
        List<CustomerDto> usersListResponse = modelMapper.map(usersList, usersDtoList);
        return usersListResponse;
    }



    @Override
    public CustomerDto updateUser(Long Id, CustomerDto customerDto) {
        Customer customer = userRepository.findById(Id).orElse(null);
        if(customer == null)
            throw new RuntimeException("User not found");
        customer.setCustomerCity(customerDto.getCustomerCity());
        customer.setCustomerPhone(customerDto.getCustomerPhone());
        Customer customerUpdated = userRepository.save(customer);
        CustomerDto c = new CustomerDto();
        BeanUtils.copyProperties(customerUpdated,c);
        return c;
    }



}








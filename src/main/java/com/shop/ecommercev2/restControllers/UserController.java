package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.requests.UserRequest;
import com.shop.ecommercev2.responses.UserResponse;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    IUserService iUserService;

    @GetMapping
    public String getUser(){
        return "get User called";
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest userRequest){


        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);

        UserDto  createUser = iUserService.createUser(userDto);


        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(createUser,userResponse);

        return userResponse;
    }



}

package com.shop.ecommercev2.restControllers;


import com.shop.ecommercev2.entities.Customer;
import com.shop.ecommercev2.requests.UserRequest;
import com.shop.ecommercev2.responses.ErrorMesage;
import com.shop.ecommercev2.responses.UserResponse;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.CustomerDto;
import com.shop.ecommercev2.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    IUserService iUserService;

    @GetMapping
    public String getUser(){
        return "get User called";
    }

    @PostMapping("/signUp")

    public UserResponse addUser(@RequestBody UserRequest userRequest) throws Exception{


        if(userRequest.getFirstname().isEmpty()) throw new Exception(ErrorMesage.MISSING_REQUIRED_FIELD.getErrorMessage());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);

        UserDto  createUser = iUserService.createUser(userDto);


        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(createUser,userResponse);

        return userResponse;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> users = iUserService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PutMapping(path="/update/{id}")
    public ResponseEntity<CustomerDto> updateUser(@PathVariable Long id, @RequestBody CustomerDto customerDto){



        CustomerDto customer = iUserService.updateUser(id, customerDto);
        return new ResponseEntity<> (customer, HttpStatus.OK);

    }



}

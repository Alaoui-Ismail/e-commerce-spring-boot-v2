package com.shop.ecommercev2.repositories;

import com.shop.ecommercev2.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<Customer,Long> {


        Customer findByEmail (String email);
}

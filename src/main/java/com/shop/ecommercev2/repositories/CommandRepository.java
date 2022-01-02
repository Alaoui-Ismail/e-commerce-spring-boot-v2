package com.shop.ecommercev2.repositories;


import com.shop.ecommercev2.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {


    @Query(nativeQuery = true, value = "SELECT command.* FROM command WHERE command.is_valid = TRUE LIMIT 1")
    Command checkCommand();

}

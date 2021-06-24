package com.zenixo.spring.repo;

import com.zenixo.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Customer, String> {

    //    @Query(value = "select custEmail,custPassword from customer where custEmail=?", nativeQuery = true)
    Optional<Customer> findCustomerByCustEmailAndAndCustPassword(String custEmail,String custPassword);


//    @Query(value = "select custEmail from customer where custEmail=?", nativeQuery = true)
//    Optional<Customer> matchLogin(String custEmail);
}

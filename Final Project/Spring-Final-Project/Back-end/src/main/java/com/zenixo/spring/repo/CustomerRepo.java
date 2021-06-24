package com.zenixo.spring.repo;

import com.zenixo.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "select * from customer where custStatus='Not Approved'", nativeQuery = true)
    ArrayList<Customer> getPendCustomers();
}

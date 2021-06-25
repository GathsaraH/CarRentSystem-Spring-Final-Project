package com.zenixo.spring.repo;

import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.entity.CustomerMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerMessageRepo extends JpaRepository<CustomerMessage, String> {

    Optional<CustomerMessage> findByCustNICNumber(Customer custNICNumber);

}

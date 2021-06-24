package com.zenixo.spring.repo;

import com.zenixo.spring.entity.CustomerMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMessageRepo extends JpaRepository<CustomerMessage, String> {
}

package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.repo.LoginRepo;
import com.zenixo.spring.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepo loginRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public CustomerDTO matchLogin(String custEmail,String custPassword) {
//        Customer customer = loginRepo.findCustomerByCustEmail(custEmail).get();
        Customer customer = loginRepo.findCustomerByCustEmailAndAndCustPassword(custEmail,custPassword).get();
        return mapper.map(customer.getCustEmail(), CustomerDTO.class);

    }
}

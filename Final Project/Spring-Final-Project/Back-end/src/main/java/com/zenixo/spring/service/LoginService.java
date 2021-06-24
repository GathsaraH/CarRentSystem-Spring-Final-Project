package com.zenixo.spring.service;

import com.zenixo.spring.dto.CustomerDTO;

public interface LoginService {
    CustomerDTO matchLogin(String custEmail,String custPassword);
}

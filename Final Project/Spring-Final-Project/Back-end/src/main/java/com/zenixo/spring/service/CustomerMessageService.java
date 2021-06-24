package com.zenixo.spring.service;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.dto.CustomerMessageDTO;

public interface CustomerMessageService {

    CustomerDTO searchCustomers(String custNICNumber);
    void addCustomerMessage(CustomerMessageDTO dto);
}

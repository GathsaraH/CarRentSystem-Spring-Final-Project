package com.zenixo.spring.service;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.dto.CustomerMessageDTO;
import com.zenixo.spring.dto.ForGetCustMsgDTO;

public interface CustomerMessageService {

    CustomerDTO searchCustomers(String custNICNumber);

    CustomerMessageDTO searchCustomersForEmail(ForGetCustMsgDTO dto);



    void addCustomerMessage(CustomerMessageDTO dto);
}

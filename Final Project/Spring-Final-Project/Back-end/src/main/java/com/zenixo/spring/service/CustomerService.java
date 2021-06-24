package com.zenixo.spring.service;

import com.zenixo.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String custNICNumber);

    ArrayList<CustomerDTO>getPendCustomers();

    void updateCustomerStatus(CustomerDTO dto);
}

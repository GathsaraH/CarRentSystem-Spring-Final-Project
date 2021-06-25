package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.dto.CustomerMessageDTO;
import com.zenixo.spring.dto.ForGetCustMsgDTO;
import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.entity.CustomerMessage;
import com.zenixo.spring.repo.CustomerMessageRepo;
import com.zenixo.spring.repo.CustomerRepo;
import com.zenixo.spring.service.CustomerMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerMessageServiceImpl implements CustomerMessageService {

    @Autowired
    CustomerMessageRepo customerMessageRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public CustomerDTO searchCustomers(String custNICNumber) {
        Optional<Customer> customer = customerRepo.findById(custNICNumber);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public CustomerMessageDTO searchCustomersForEmail(ForGetCustMsgDTO dto) {
        Optional<CustomerMessage> byCustNICNumber = customerMessageRepo.findByCustNICNumber(dto.getCustNICNumber());
        if (byCustNICNumber.isPresent()) {
            return mapper.map(byCustNICNumber.get(), CustomerMessageDTO.class);
        }
        return null;
    }

    @Override
    public void addCustomerMessage(CustomerMessageDTO dto) {
        CustomerMessage message = new CustomerMessage(
                dto.getStatusHead(),
                dto.getStatusMessage(),
                dto.getCustomerEmail(),
                dto.getCustNICNumber()
        );
        customerMessageRepo.save(message);

    }
}

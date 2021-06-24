package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.repo.CustomerRepo;
import com.zenixo.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void saveCustomer(CustomerDTO d) {
        Customer customer = new Customer(
                d.getCustNICNumber(),
                d.getCustName(),
                d.getCustAddress(),
                d.getCustNICImage(),
                d.getCustDrivingImage(),
                d.getCustDrivingNumber(),
                d.getCustContact(),
                d.getCustEmail(),
                d.getCustPassword(),
                "Not Approved"


        );
        customerRepo.save(customer);
    }

    @Override
    public CustomerDTO searchCustomer(String custNICNumber) {
        Optional<Customer> customer = customerRepo.findById(custNICNumber);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }


    @Override
    public ArrayList<CustomerDTO> getPendCustomers() {
        List<Customer> customers = customerRepo.getPendCustomers();
        return mapper.map(customers, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void updateCustomerStatus(CustomerDTO dto) {
        Customer customer1 = customerRepo.findById(dto.getCustNICNumber()).get();
        customer1.setCustStatus("Approved");
        customerRepo.save(customer1);
//        Customer customer = new Customer(
//                dto.getCustNICNumber(),
//                dto.getCustName(),
//                dto.getCustAddress(),
//                dto.getCustNICImage(),
//                dto.getCustDrivingImage(),
//                dto.getCustDrivingNumber(),
//                dto.getCustContact(),
//                dto.getCustEmail(),
//                dto.getCustPassword(),
//                dto.getCustStatus()
//        );
//        customerRepo.save(customer);
    }
}

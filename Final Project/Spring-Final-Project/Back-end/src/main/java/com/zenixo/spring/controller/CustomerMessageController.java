package com.zenixo.spring.controller;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.dto.CustomerMessageDTO;
import com.zenixo.spring.dto.ForGetCustMsgDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.CustomerMessageService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@RequestMapping("/customerMessage")
@EnableWebMvc
public class CustomerMessageController {
    @Autowired
    CustomerMessageService customerMessageService;

    @GetMapping(path = "/{custNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String custNICNumber) {
        System.out.println("custNICNumber ID Search");
        System.out.println("custNICNumber ID Search" + custNICNumber);

        CustomerDTO customerDTO = customerMessageService.searchCustomers(custNICNumber);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody CustomerMessageDTO dto) {
        System.out.println("dto = " + dto);
        if (dto.getCustomerEmail().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerMessageService.addCustomerMessage(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity searchCustomerForEmail(@RequestBody ForGetCustMsgDTO dto) {
        System.out.println("custNICNumber ID Search");
        System.out.println("custNICNumber ID Search" + dto);

        CustomerMessageDTO customerDTO = customerMessageService.searchCustomersForEmail(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }
}



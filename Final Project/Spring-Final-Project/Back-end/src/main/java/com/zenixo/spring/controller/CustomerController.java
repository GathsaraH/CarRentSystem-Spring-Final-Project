package com.zenixo.spring.controller;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.CustomerService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getCustNICNumber().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerService.saveCustomer(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PostMapping("/file")
    public ResponseEntity saveFile(@RequestPart("file") MultipartFile myFile) {
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            System.out.println("projectPath = " + projectPath);
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            return new ResponseEntity(new StandardResponse("200", "Done", myFile.getOriginalFilename()), HttpStatus.OK);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity(new StandardResponse("500", "Done", false), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(new StandardResponse("500", "Done", false), HttpStatus.OK);
        }
    }



    @GetMapping(path = "/{custNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String custNICNumber) {
        System.out.println("Customer ID Search");
        System.out.println("Customer ID Search" + custNICNumber);

        CustomerDTO customerDTO = customerService.searchCustomer(custNICNumber);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPendingCustomers() {
        ArrayList<CustomerDTO> customerDTOS = customerService.getPendCustomers();
        System.out.println("bookingDTOS = " + customerDTOS);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTOS), HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePendRequest(@RequestBody CustomerDTO dto) {
        if (dto.getCustNICNumber().trim().length() <= 0) {
            System.out.println("dto = " + dto);
            throw new NotFoundException("No id provided to update");
        }
        customerService.updateCustomerStatus(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }




}

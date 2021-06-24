package com.zenixo.spring.controller;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.service.LoginService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@RequestMapping("/login")
@EnableWebMvc
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping(path = "/{custEmail}/{custPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity matchLogin(@PathVariable String custEmail, @PathVariable String custPassword) {
//        System.out.println("Customer Password" + custPassword);
        System.out.println("Customer Email" + custEmail);

        CustomerDTO customerDTO = loginService.matchLogin(custEmail, custPassword);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }
}

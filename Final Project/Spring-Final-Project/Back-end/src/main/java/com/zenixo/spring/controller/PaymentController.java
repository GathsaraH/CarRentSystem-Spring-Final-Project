package com.zenixo.spring.controller;

import com.zenixo.spring.dto.BookingDTO;
import com.zenixo.spring.dto.CustomDTO;
import com.zenixo.spring.dto.CustomerMessageDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.CustomerMessageService;
import com.zenixo.spring.service.PaymentService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@RequestMapping("/payment")
@EnableWebMvc
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    CustomerMessageService customerMessageService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody CustomDTO dto) {
        System.out.println("dto = " + dto);
        if (dto.getVehicleRegID().trim().length() <= 0) {
            throw new NotFoundException("Booking id cannot be empty");
        }
        paymentService.addPayment(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


}

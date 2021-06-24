package com.zenixo.spring.controller;

import com.zenixo.spring.dto.CustomDTO;
import com.zenixo.spring.service.DriverService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/return")
@EnableWebMvc
public class ReturnController {

    @Autowired
    DriverService driverService;


    @GetMapping(path = "/{vehicleRegID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReturns(@PathVariable String vehicleRegID) {
        System.out.println("Driver ID Search");
        System.out.println("Vehicle ID Search" + vehicleRegID);

        ArrayList<CustomDTO> bookingDTOS = driverService.getReturn(vehicleRegID);
        return new ResponseEntity(new StandardResponse("200", "Done", bookingDTOS), HttpStatus.OK);
    }



}

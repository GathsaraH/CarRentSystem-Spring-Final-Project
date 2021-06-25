package com.zenixo.spring.controller;

import com.zenixo.spring.dto.DriverScheduleDTO;
import com.zenixo.spring.service.DriverSheduleService;
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
@RequestMapping("/driverShedule")
@EnableWebMvc
public class DriverSheduleController {
    @Autowired
    DriverSheduleService driverSheduleService;

    @GetMapping(path = "/{driverNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDriverShedule(@PathVariable String driverNICNumber) {
        System.out.println("Customer ID Search");
        System.out.println("Customer ID Search" + driverNICNumber);

        ArrayList<DriverScheduleDTO> customerDTO = driverSheduleService.searchDriverShedule(driverNICNumber);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }
}

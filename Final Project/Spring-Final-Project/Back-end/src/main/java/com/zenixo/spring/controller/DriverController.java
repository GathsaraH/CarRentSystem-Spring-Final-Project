package com.zenixo.spring.controller;

import com.zenixo.spring.dto.DriverDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.DriverService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody DriverDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getDriverNICNumber().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        driverService.addDrivers(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(path = "/{driverNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDrivers(@PathVariable String driverNICNumber) {
        System.out.println("Driver ID Search");
        System.out.println("Drive ID Search" + driverNICNumber);

        DriverDTO driverDTO = driverService.searchDrive(driverNICNumber);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getNotAssignDrivers() {
        ArrayList<DriverDTO> allDrivers = driverService.getNotAssignDrivers();
        System.out.println("allDrivers = " + allDrivers);
        return new ResponseEntity(new StandardResponse("200", "Done", allDrivers), HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriverStatus(@RequestBody DriverDTO driverDTO) {
        driverService.updateDriverStatus(driverDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

}

package com.zenixo.spring.controller;

import com.zenixo.spring.dto.VehicleDTO;
import com.zenixo.spring.dto.VehicleIDDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.VehicleService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getVehicleRegID().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        vehicleService.addVehicle(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> allVehicle = vehicleService.getAllVehicle();
        return new ResponseEntity(new StandardResponse("200", "Done", allVehicle), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriverStatus(@RequestBody VehicleIDDTO vehicleIDDTO) {
        System.out.println("vehicleIDDTO = " + vehicleIDDTO);
        vehicleService.updateVehicle(vehicleIDDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleIDDTO), HttpStatus.OK);
    }


    @GetMapping(path = "/{vehicleRegID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReturnVehicle(@PathVariable String vehicleRegID) {
        System.out.println("Vehicle ID Search");
        System.out.println("Vehicle ID Search" + vehicleRegID);

        VehicleDTO vehicleDTO = vehicleService.getReturns(vehicleRegID);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }


}

package com.zenixo.spring.controller;

import com.zenixo.spring.dto.BookingAccreptDTO;
import com.zenixo.spring.dto.BookingDTO;
import com.zenixo.spring.exception.NotFoundException;
import com.zenixo.spring.service.BookingService;
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
@RequestMapping("/booking")
@EnableWebMvc
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody BookingDTO dto) {
        System.out.println("dto = " + dto);
        if (dto.getBookingID().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        bookingService.addBooking(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPendingRent() {
        ArrayList<BookingAccreptDTO> bookingDTOS = bookingService.getPendingRent();
        System.out.println("bookingDTOS = " + bookingDTOS);
        return new ResponseEntity(new StandardResponse("200", "Done", bookingDTOS), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity updatePendRequest(@RequestBody BookingDTO dto) {
        if (dto.getBookingID().trim().length() <= 0) {
            System.out.println("dto = " + dto);
            throw new NotFoundException("No id provided to update");
        }
        bookingService.updatePend(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


    @PostMapping("/vehicle")
    public ResponseEntity updateVehicle(@RequestBody BookingDTO dto) {
        if (dto.getBookingID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        System.out.println("Vehicle Update = " + dto);
        bookingService.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


    @PostMapping("/vehicleReject")
    public ResponseEntity updateReject(@RequestBody BookingDTO dto) {
        if (dto.getBookingID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        System.out.println("Vehicle Update = " + dto);
        bookingService.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }





//    @GetMapping(path = "/{bookingID}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getBooking(@PathVariable String bookingID) {
//        System.out.println("Vehicle ID Search");
//        System.out.println("Vehicle ID Search" + bookingID);
//        ArrayList<BookingDetailsDTO> list = bookingDetailsService.getBookingVehicle(bookingID);
//        return new ResponseEntity(new StandardResponse("200", "Done", bookingID), HttpStatus.OK);
//    }

    @GetMapping(path = "/{bookingID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String bookingID) {
        System.out.println("bookingID ID Search");
        System.out.println("bookingID ID Search" + bookingID);

        BookingDTO bookingDTO = bookingService.searchBooking(bookingID);
        return new ResponseEntity(new StandardResponse("200", "Done", bookingDTO), HttpStatus.OK);
    }


}

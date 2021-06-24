package com.zenixo.spring.controller;


import com.zenixo.spring.dto.BookingDetailsDTO;
import com.zenixo.spring.service.BookingDetailsService;
import com.zenixo.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/bookingDetails")
public class BookingDetailsController {
    @Autowired
    BookingDetailsService bookingDetailsService;

    @GetMapping(path = "/{bookingID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBooking(@PathVariable String bookingID) {
        System.out.println("Vehicle ID Search");
        System.out.println("Vehicle ID Search" + bookingID);
        ArrayList<BookingDetailsDTO> list = bookingDetailsService.getBookingVehicle(bookingID);
        return new ResponseEntity(new StandardResponse("200", "Done", bookingID), HttpStatus.OK);
    }

}

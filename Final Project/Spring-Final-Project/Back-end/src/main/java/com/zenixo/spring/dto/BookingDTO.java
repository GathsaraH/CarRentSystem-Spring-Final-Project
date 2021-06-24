package com.zenixo.spring.dto;

import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.entity.Drivers;
import com.zenixo.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String bookingID;
    private String rentDate;
    private String returnDate;
    private String bookingStatus;
    private String rentStatus;
    private Customer custNICNumber;
    private List<BookingDetailsDTO> bookingDetails = new ArrayList<>();






    public BookingDTO(String bookingID, String rentDate, String returnDate, String bookingStatus, Customer custNICNumber) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookingStatus = bookingStatus;
        this.custNICNumber = custNICNumber;
    }

    public BookingDTO(String bookingID, String rentDate, String returnDate, String bookingStatus, Customer custNICNumber, List<BookingDetailsDTO> bookingDetails ) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookingStatus = bookingStatus;
        this.custNICNumber = custNICNumber;
        this.bookingDetails = bookingDetails;
    }





    public BookingDTO(Customer custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    public BookingDTO(List<BookingDetailsDTO> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }



}

package com.zenixo.spring.dto;

import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnBookingDTO {
    private String bookingID;
    private String rentDate;
    private String returnDate;
    private Customer custNICNumber;
    List<BookingDetails> bookingDetails=new ArrayList<>();

    public ReturnBookingDTO(String bookingID) {
        this.bookingID = bookingID;
    }


}

package com.zenixo.spring.dto;


import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Data
public class BookingAccreptDTO {
    private String bookingID;
    private String rentDate;
    private String returnDate;
    private String bookingStatus;
    private Customer custNICNumber;
    private List<BookingDetails> bookingDetails = new ArrayList<>();

    public BookingAccreptDTO() {
    }

    public BookingAccreptDTO(String bookingID, String rentDate, String returnDate, String bookingStatus, Customer custNICNumber, List<BookingDetails> bookingDetails) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookingStatus = bookingStatus;
        this.custNICNumber = custNICNumber;
        this.bookingDetails = bookingDetails;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Customer getCustNICNumber() {
        return custNICNumber;
    }

    public void setCustNICNumber(Customer custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}

package com.zenixo.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    private String bookingID;
    private String rentDate;
    private String returnDate;
    private String bookingStatus; //For Admin Approvel
    private String rentStatus;

    @ManyToOne
    @JoinColumn(name = "custNICNumber", referencedColumnName = "custNICNumber")
    private Customer custNICNumber;



    //If Not required Then Send Not Assign else Send Drive Id


    @OneToMany(mappedBy = "bookingID")
    @JsonIgnore
    private List<BookingDetails> bookingDetails = new ArrayList<>();


    public Booking(String bookingID, String rentDate, String returnDate, String bookingStatus, String rentStatus, Customer custNICNumber) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookingStatus = bookingStatus;
        this.rentStatus = rentStatus;
        this.custNICNumber = custNICNumber;

    }

    public Booking(String bookingID, String rentDate, String returnDate, String bookingStatus, Customer custNICNumber, List<BookingDetails> bookingDetails) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.bookingStatus = bookingStatus;
        this.custNICNumber = custNICNumber;
        this.bookingDetails = bookingDetails;
    }
}

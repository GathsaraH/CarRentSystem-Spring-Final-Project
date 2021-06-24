package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;
    private double finalPayment;
    @ManyToOne
    @JoinColumn(name = "custNICNumber", referencedColumnName = "custNICNumber")
    private Customer custNICNumber;
    @ManyToOne
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID")
    private Booking bookingID;

    public Payment(double finalPayment, Customer custNICNumber, Booking bookingID) {
        this.finalPayment = finalPayment;
        this.custNICNumber = custNICNumber;
        this.bookingID = bookingID;
    }


}

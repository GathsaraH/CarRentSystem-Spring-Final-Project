package com.zenixo.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingDetailsID;
    private double lossDamage;
    private String lossDamageImage;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID")
    private Booking bookingID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "vehicleRegID", referencedColumnName = "vehicleRegID")
    private Vehicle vehicleRegID;

    @ManyToOne
    @JoinColumn(name = "driverNICNumber", referencedColumnName = "driverNICNumber")
    private Drivers driverNICNumber;

    public BookingDetails(double lossDamage, String lossDamageImage, Booking bookingID, Vehicle vehicleRegID) {
        this.lossDamage = lossDamage;
        this.lossDamageImage = lossDamageImage;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
    }



    public BookingDetails() {
    }

    public BookingDetails(int bookingDetailsID, double lossDamage, String lossDamageImage, Booking bookingID, Vehicle vehicleRegID,Drivers driverNICNumber) {
        this.bookingDetailsID = bookingDetailsID;
        this.lossDamage = lossDamage;
        this.lossDamageImage = lossDamageImage;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
        this.driverNICNumber=driverNICNumber;

    }

    public BookingDetails(double lossDamage, String lossDamageImage, Booking bookingID, Vehicle vehicleRegID, Drivers driverNICNumber) {
        this.lossDamage = lossDamage;
        this.lossDamageImage = lossDamageImage;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
        this.driverNICNumber = driverNICNumber;
    }

    public int getBookingDetailsID() {
        return bookingDetailsID;
    }

    public void setBookingDetailsID(int bookingDetailsID) {
        this.bookingDetailsID = bookingDetailsID;
    }

    public double getLossDamage() {
        return lossDamage;
    }

    public void setLossDamage(double lossDamage) {
        this.lossDamage = lossDamage;
    }

    public String getLossDamageImage() {
        return lossDamageImage;
    }

    public void setLossDamageImage(String lossDamageImage) {
        this.lossDamageImage = lossDamageImage;
    }

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    public Vehicle getVehicleRegID() {
        return vehicleRegID;
    }

    public void setVehicleRegID(Vehicle vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }


    public BookingDetails(Vehicle vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }

    public Drivers getDriverNICNumber() {
        return driverNICNumber;
    }

    public void setDriverNICNumber(Drivers driverNICNumber) {
        this.driverNICNumber = driverNICNumber;
    }


}

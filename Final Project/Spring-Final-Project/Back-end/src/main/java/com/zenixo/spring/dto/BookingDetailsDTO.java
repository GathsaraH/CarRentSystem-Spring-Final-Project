package com.zenixo.spring.dto;

import com.zenixo.spring.entity.Booking;
import com.zenixo.spring.entity.Drivers;
import com.zenixo.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class BookingDetailsDTO {
    private int bookingDetailsID;
    private double lossDamage;
    private String lossDamageImage;
    private Booking bookingID;
    private Vehicle vehicleRegID;
    private Drivers driverNICNumber;

    public BookingDetailsDTO() {
    }

    public BookingDetailsDTO(int bookingDetailsID, double lossDamage, String lossDamageImage, Booking bookingID, Vehicle vehicleRegID,Drivers driverNICNumber) {
        this.bookingDetailsID = bookingDetailsID;
        this.lossDamage = lossDamage;
        this.lossDamageImage = lossDamageImage;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
        this.driverNICNumber=driverNICNumber;
    }

    public Drivers getDriverNICNumber() {
        return driverNICNumber;
    }

    public void setDriverNICNumber(Drivers driverNICNumber) {
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

    public BookingDetailsDTO(Vehicle vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }

    @Override
    public String toString() {
        return "BookingDetailsDTO{" +
                "bookingDetailsID=" + bookingDetailsID +
                ", lossDamage=" + lossDamage +
                ", lossDamageImage='" + lossDamageImage + '\'' +
                ", bookingID=" + bookingID +
                ", vehicleRegID=" + vehicleRegID +
                '}';
    }
}

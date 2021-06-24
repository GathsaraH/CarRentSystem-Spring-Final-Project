package com.zenixo.spring.dto;

import com.zenixo.spring.entity.Booking;
import com.zenixo.spring.entity.Customer;
import com.zenixo.spring.entity.Drivers;
import com.zenixo.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


public class CustomDTO {
    private String bookingID;
    private String rentDate;
    private String returnDate;
    private String custNICNumber;
    private double lossDamage;
    private String driverNICNumber;
    private String vehicleRegID;
    private double finalPayment;

    public CustomDTO() {
    }

    public CustomDTO(String bookingID, String rentDate, String returnDate, String custNICNumber, double lossDamage, String driverNICNumber, String vehicleRegID) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.custNICNumber = custNICNumber;
        this.lossDamage = lossDamage;
        this.driverNICNumber = driverNICNumber;
        this.vehicleRegID = vehicleRegID;
    }

    public CustomDTO(String bookingID, String rentDate, String returnDate, String custNICNumber, double lossDamage, String driverNICNumber, String vehicleRegID, double finalPayment) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.custNICNumber = custNICNumber;
        this.lossDamage = lossDamage;
        this.driverNICNumber = driverNICNumber;
        this.vehicleRegID = vehicleRegID;
        this.finalPayment = finalPayment;
    }

    public CustomDTO(String bookingID, String custNICNumber, double finalPayment) {
        this.bookingID = bookingID;
        this.custNICNumber = custNICNumber;
        this.finalPayment = finalPayment;
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

    public String getCustNICNumber() {
        return custNICNumber;
    }

    public void setCustNICNumber(String custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    public double getLossDamage() {
        return lossDamage;
    }

    public void setLossDamage(double lossDamage) {
        this.lossDamage = lossDamage;
    }

    public String getDriverNICNumber() {
        return driverNICNumber;
    }

    public void setDriverNICNumber(String driverNICNumber) {
        this.driverNICNumber = driverNICNumber;
    }

    public String getVehicleRegID() {
        return vehicleRegID;
    }

    public void setVehicleRegID(String vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }

    public double getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(double finalPayment) {
        this.finalPayment = finalPayment;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "bookingID='" + bookingID + '\'' +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", custNICNumber='" + custNICNumber + '\'' +
                ", lossDamage=" + lossDamage +
                ", driverNICNumber='" + driverNICNumber + '\'' +
                ", vehicleRegID='" + vehicleRegID + '\'' +
                '}';
    }
}

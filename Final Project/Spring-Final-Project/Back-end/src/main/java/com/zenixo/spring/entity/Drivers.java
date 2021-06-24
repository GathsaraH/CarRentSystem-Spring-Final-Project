package com.zenixo.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Drivers {
    @Id
    private String driverNICNumber;
    private String driverName;
    private String driverNICImage;
    private String driverDrivingLyImage;
    private String driverDrivingLyNumber;
    private String driverContact;
    private String driverEmail;
    private String driverPassword;
    private String driverStatus;

    public Drivers() {
    }

    public Drivers(String driverNICNumber, String driverName, String driverNICImage, String driverDrivingLyImage, String driverDrivingLyNumber, String driverContact, String driverEmail, String driverPassword, String driverStatus, List<BookingDetails> bookingDetails) {
        this.driverNICNumber = driverNICNumber;
        this.driverName = driverName;
        this.driverNICImage = driverNICImage;
        this.driverDrivingLyImage = driverDrivingLyImage;
        this.driverDrivingLyNumber = driverDrivingLyNumber;
        this.driverContact = driverContact;
        this.driverEmail = driverEmail;
        this.driverPassword = driverPassword;
        this.driverStatus = driverStatus;
        this.bookingDetails = bookingDetails;
    }


    @OneToMany(mappedBy = "driverNICNumber", cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JsonIgnore
    private List<BookingDetails> bookingDetails;





    public Drivers(String driverNICNumber, String driverName, String driverNICImage, String driverDrivingLyImage, String driverDrivingLyNumber, String driverContact, String driverEmail, String driverPassword, String driverStatus) {
        this.driverNICNumber = driverNICNumber;
        this.driverName = driverName;
        this.driverNICImage = driverNICImage;
        this.driverDrivingLyImage = driverDrivingLyImage;
        this.driverDrivingLyNumber = driverDrivingLyNumber;
        this.driverContact = driverContact;
        this.driverEmail = driverEmail;
        this.driverPassword = driverPassword;
        this.driverStatus = driverStatus;
    }


    public String getDriverNICNumber() {
        return driverNICNumber;
    }

    public void setDriverNICNumber(String driverNICNumber) {
        this.driverNICNumber = driverNICNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNICImage() {
        return driverNICImage;
    }

    public void setDriverNICImage(String driverNICImage) {
        this.driverNICImage = driverNICImage;
    }

    public String getDriverDrivingLyImage() {
        return driverDrivingLyImage;
    }

    public void setDriverDrivingLyImage(String driverDrivingLyImage) {
        this.driverDrivingLyImage = driverDrivingLyImage;
    }

    public String getDriverDrivingLyNumber() {
        return driverDrivingLyNumber;
    }

    public void setDriverDrivingLyNumber(String driverDrivingLyNumber) {
        this.driverDrivingLyNumber = driverDrivingLyNumber;
    }

    public String getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}

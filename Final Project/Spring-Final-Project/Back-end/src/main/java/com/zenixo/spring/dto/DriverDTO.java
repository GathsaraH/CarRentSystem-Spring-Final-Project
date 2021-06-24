package com.zenixo.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driverNICNumber;
    private String driverName;
    private String driverNICImage;
    private String driverDrivingLyImage;
    private String driverDrivingLyNumber;
    private String driverContact;
    private String driverEmail;
    private String driverPassword;
    private String driverStatus;

    public DriverDTO(String driverNICNumber) {
        this.driverNICNumber = driverNICNumber;
    }
}

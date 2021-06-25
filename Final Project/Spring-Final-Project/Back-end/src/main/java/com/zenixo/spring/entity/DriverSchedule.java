package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DriverSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleID;
    String startDate;
    String endDate;
    String driverStatus;
    @ManyToOne
    @JoinColumn(name = "driverNICNumber", referencedColumnName = "driverNICNumber")
    private Drivers driverNICNumber;

    public DriverSchedule(String startDate, String endDate, String driverStatus, Drivers driverNICNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.driverStatus = driverStatus;
        this.driverNICNumber = driverNICNumber;
    }


    public DriverSchedule(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public String setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
        return driverStatus;
    }
}

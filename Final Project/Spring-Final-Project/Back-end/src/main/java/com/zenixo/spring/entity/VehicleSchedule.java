package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VehicleSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleID;
    String startDate;
    String endDate;
    String vehicleStatus;
    @ManyToOne
    @JoinColumn(name = "vehicleRegID", referencedColumnName = "vehicleRegID")
    private Vehicle vehicleRegID;

    public VehicleSchedule(String startDate, String endDate, String vehicleStatus, Vehicle vehicleRegID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicleStatus = vehicleStatus;
        this.vehicleRegID = vehicleRegID;
    }
}

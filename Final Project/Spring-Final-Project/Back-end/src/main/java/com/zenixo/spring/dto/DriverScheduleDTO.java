package com.zenixo.spring.dto;

import com.zenixo.spring.entity.Drivers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverScheduleDTO {
    private int scheduleID;
    String startDate;
    String endDate;
    String driverStatus;
    private Drivers driverNICNumber;

    public DriverScheduleDTO(String startDate, String endDate, String driverStatus, Drivers driverNICNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.driverStatus = driverStatus;
        this.driverNICNumber = driverNICNumber;
    }
}

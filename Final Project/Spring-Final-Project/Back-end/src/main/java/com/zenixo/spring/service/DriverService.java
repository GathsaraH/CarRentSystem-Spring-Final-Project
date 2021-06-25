package com.zenixo.spring.service;

import com.zenixo.spring.dto.*;
import com.zenixo.spring.entity.BookingDetails;

import java.util.ArrayList;
import java.util.List;

public interface DriverService {
    void addDrivers(DriverDTO dto);

    DriverDTO searchDrive(String driverNICNumber);

    ArrayList<DriverDTO> getNotAssignDrivers();

    BookingDetailsDTO getReturns(String vehicleRegID);

    ArrayList<CustomDTO> getReturn(String vehicleRegID);

    void updateDriverStatus(DriverDTO driverNICNumber);

    ArrayList<DriverDTO>getAllDrivers();
}

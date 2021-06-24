package com.zenixo.spring.service;

import com.zenixo.spring.dto.BookingDetailsDTO;
import com.zenixo.spring.dto.VehicleDTO;
import com.zenixo.spring.dto.VehicleIDDTO;

import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);

    ArrayList<VehicleDTO> getAllVehicle();

    void updateVehicle(VehicleIDDTO dto);

    VehicleDTO getReturns(String vehicleRegID);

}

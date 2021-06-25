package com.zenixo.spring.service;

import com.zenixo.spring.dto.CustomerDTO;
import com.zenixo.spring.dto.DriverScheduleDTO;
import com.zenixo.spring.entity.DriverSchedule;

import java.util.ArrayList;

public interface DriverSheduleService {
    ArrayList<DriverScheduleDTO> searchDriverShedule(String driverNICNumber);
}

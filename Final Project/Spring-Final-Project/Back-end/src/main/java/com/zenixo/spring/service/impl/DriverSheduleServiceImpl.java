package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.DriverScheduleDTO;
import com.zenixo.spring.entity.DriverSchedule;
import com.zenixo.spring.repo.DriverSheduleRepo;
import com.zenixo.spring.service.DriverSheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverSheduleServiceImpl implements DriverSheduleService {
    @Autowired
    DriverSheduleRepo driverSheduleRepo;

    @Override
    public ArrayList<DriverScheduleDTO> searchDriverShedule(String driverNICNumber) {
        ArrayList<DriverScheduleDTO> list = new ArrayList<>();
        List<DriverSchedule> byDriverNICNumber = driverSheduleRepo.findByDriverNICNumber(driverNICNumber);
        for (DriverSchedule d : byDriverNICNumber) {
            list.add(new DriverScheduleDTO(
                    d.getStartDate(),
                    d.getEndDate(),
                    d.getDriverStatus(),
                    d.getDriverNICNumber()
            ));
        }
        return list;
    }
}

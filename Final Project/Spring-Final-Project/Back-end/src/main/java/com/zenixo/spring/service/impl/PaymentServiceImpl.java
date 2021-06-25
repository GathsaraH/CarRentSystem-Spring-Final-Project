package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.CustomDTO;
import com.zenixo.spring.entity.*;
import com.zenixo.spring.repo.*;
import com.zenixo.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    BookingDetailsRepo bookingDetailsRepo;
    @Autowired
    DriverRepo driverRepo;
    @Autowired
    VehicleRepo vehicleRepo;
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    DriverSheduleRepo driverSheduleRepo;
    @Autowired
    VehicleScheduleRepo vehicleScheduleRepo;

    @Override
    public void addPayment(CustomDTO dto) {
        Booking booking = bookingRepo.findById(dto.getBookingID()).get();
        Customer customer = customerRepo.findById(dto.getCustNICNumber()).get();
        Payment p = new Payment(
                dto.getFinalPayment(),
                customer,
                booking
        );
        Payment save = paymentRepo.save(p);
        if (save != null) {
            Drivers drivers = driverRepo.findById(dto.getDriverNICNumber()).get();
            drivers.setDriverStatus("NOT ASSIGN");
            Drivers save1 = driverRepo.save(drivers);
            if (save1 != null) {
                Vehicle vehicle = vehicleRepo.findById(dto.getVehicleRegID()).get();
                vehicle.setVehicleStatus("Free");
                Vehicle save2 = vehicleRepo.save(vehicle);
                if (save2 != null) {
                    Booking booking1 = bookingRepo.findById(dto.getBookingID()).get();
                    booking1.setRentStatus("All Done");
                    Booking save3 = bookingRepo.save(booking1);
                    if (save3 != null) {
                        List<DriverSchedule> list = driverSheduleRepo.findByDriverNICNumber(dto.getDriverNICNumber());
                        for (DriverSchedule d : list) {
                            DriverSchedule schedule = new DriverSchedule(
                                    d.setDriverStatus("Free")
                            );
                            driverSheduleRepo.save(schedule);
                        }

//                        driverSheduleRepo.save(byDriverNICNumber);
//                        if (save4 != null) {
//                            VehicleSchedule schedule1 = vehicleScheduleRepo.findByVehicleRegID(dto.getVehicleRegID());
//                            schedule1.setStartDate("Free");
//                            VehicleSchedule save5 = vehicleScheduleRepo.save(schedule1);
//                        }

                    }
                }
            }

        }
    }
}

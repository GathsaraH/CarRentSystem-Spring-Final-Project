package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.BookingAccreptDTO;
import com.zenixo.spring.dto.BookingDTO;
import com.zenixo.spring.dto.BookingDetailsDTO;
import com.zenixo.spring.entity.*;
import com.zenixo.spring.repo.*;
import com.zenixo.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
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
    DriverSheduleRepo driverSheduleRepo;
    @Autowired
    VehicleScheduleRepo vehicleScheduleRepo;


    @Override
    public void addBooking(BookingDTO dto) {
        Booking booking = new Booking(
                dto.getBookingID(),
                dto.getRentDate(),
                dto.getReturnDate(),
                "Not Approved",
                "On Rent",
                dto.getCustNICNumber()
        );

        Booking bookingSaved = bookingRepo.save(booking);

        System.out.println("Update Test" + dto);

        if (bookingSaved != null) {
            for (BookingDetailsDTO bok : dto.getBookingDetails()) {
                BookingDetails bookingDetails = new BookingDetails(
                        bok.getLossDamage(),
                        bok.getLossDamageImage(),
                        bok.getBookingID(),
                        bok.getVehicleRegID(),
                        bok.getDriverNICNumber()
                );
                BookingDetails save = bookingDetailsRepo.save(bookingDetails);

                System.out.println("Get VEHICLE ID" + bok.getVehicleRegID());

                if (save != null) {
                    Vehicle vehicle = vehicleRepo.findById(bok.getVehicleRegID().getVehicleRegID()).get();
                    System.out.println("vehicle = " + vehicle);
                    vehicle.setVehicleStatus("OnUse");
                    Vehicle save1 = vehicleRepo.save(vehicle);
                    System.out.println("SAVE BOOKING STATUS = " + save1);

                    if (save1 != null) {
                        Drivers drivers = driverRepo.findById(bok.getDriverNICNumber().getDriverNICNumber()).get();
                        drivers.setDriverStatus("ASSIGN");
                        Drivers save2 = driverRepo.save(drivers);
                        if (save2 != null) {
                            Drivers drivers1 = driverRepo.findById(bok.getDriverNICNumber().getDriverNICNumber()).get();
                            DriverSchedule schedule = new DriverSchedule(
                                    dto.getRentDate(),
                                    dto.getRentDate(),
                                    "On  Work",
                                    drivers1
                            );
                            DriverSchedule save3 = driverSheduleRepo.save(schedule);
                            if (save3 != null) {
                                Vehicle vehicle1 = vehicleRepo.findById(bok.getVehicleRegID().getVehicleRegID()).get();
                                VehicleSchedule vehicleSchedule = new VehicleSchedule(
                                        dto.getRentDate(),
                                        dto.getRentDate(),
                                        "On Work",
                                        vehicle1
                                );
                                VehicleSchedule save4 = vehicleScheduleRepo.save(vehicleSchedule);
                            }
                        }
                    }
                }
            }
        }

    }


    @Override
    public void updateVehicle(BookingDTO dto) {
        System.out.println("LAST CHECK REJECT = " + dto);
        Booking booking = bookingRepo.findById(dto.getBookingID()).get();
        booking.setBookingStatus("Rejected");
        Booking save = bookingRepo.save(booking);
        if (save != null) {
            for (BookingDetailsDTO bok : dto.getBookingDetails()) {
                Vehicle vehicle = vehicleRepo.findById(bok.getVehicleRegID().getVehicleRegID()).get();
                System.out.println("vehicle = " + vehicle);
                vehicle.setVehicleStatus("Free");
                Vehicle save1 = vehicleRepo.save(vehicle);
                if (save1 != null) {
                    Drivers drivers = driverRepo.findById(bok.getDriverNICNumber().getDriverNICNumber()).get();
                    drivers.setDriverStatus("NOT ASSIGN");
                    driverRepo.save(drivers);
                }

            }
        }

    }

    @Override
    public void updateReject(BookingDTO dto) {
        Booking booking = bookingRepo.findById(dto.getBookingID()).get();
        booking.setBookingStatus("Rejected");
        Booking save = bookingRepo.save(booking);
        if (save != null) {
            for (BookingDetailsDTO bok : dto.getBookingDetails()) {
                Vehicle vehicle = vehicleRepo.findById(bok.getVehicleRegID().getVehicleRegID()).get();
                vehicle.setVehicleStatus("Free");
                Vehicle save1 = vehicleRepo.save(vehicle);
                if (save1 != null) {
                    Drivers drivers = driverRepo.findById(bok.getDriverNICNumber().getDriverNICNumber()).get();
                    drivers.setDriverStatus("NOT ASSIGN");
                    driverRepo.save(drivers);
                }
            }
        }
    }


    @Override
    public ArrayList<BookingAccreptDTO> getPendingRent() {
        ArrayList<BookingAccreptDTO> bookingDTOS = new ArrayList<>();
        List<Booking> all = bookingRepo.getPendingRent();
        System.out.println("all = " + all);
        for (Booking b : all) {
            bookingDTOS.add(new BookingAccreptDTO(
                    b.getBookingID(),
                    b.getRentDate(),
                    b.getRentDate(),
                    b.getBookingStatus(),
                    b.getCustNICNumber(),
                    b.getBookingDetails()
            ));
            System.out.println("b.getBookingStatus() = " + b.getBookingDetails());

        }
        return bookingDTOS;
    }


    @Override
    public void updatePend(BookingDTO dto) {
        Booking booking = new Booking(
                dto.getBookingID(),
                dto.getRentDate(),
                dto.getReturnDate(),
                dto.getBookingStatus(),
                dto.getRentStatus(),
                dto.getCustNICNumber()

        );
        bookingRepo.save(booking);
    }


    @Override
    public BookingDTO searchBooking(String bookingID) {
        Optional<Booking> booking = bookingRepo.findById(bookingID);
        if (booking.isPresent()) {
            System.out.println("booking = " + booking);
            return mapper.map(booking.get(), BookingDTO.class);
        }
        return null;
    }

    @Override
    public String getLastRid() {
        return bookingRepo.getLastID();
    }
}

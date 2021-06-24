package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.BookingDetailsDTO;
import com.zenixo.spring.dto.CustomDTO;
import com.zenixo.spring.dto.DriverDTO;
import com.zenixo.spring.dto.ReturnBookingDTO;
import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Drivers;
import com.zenixo.spring.repo.BookingDetailsRepo;
import com.zenixo.spring.repo.BookingRepo;
import com.zenixo.spring.repo.DriverRepo;
import com.zenixo.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private BookingDetailsRepo detailsRepo;

    @Override
    public void addDrivers(DriverDTO dto) {
        Drivers drivers = new Drivers(
                dto.getDriverNICNumber(),
                dto.getDriverName(),
                dto.getDriverNICImage(),
                dto.getDriverDrivingLyImage(),
                dto.getDriverDrivingLyNumber(),
                dto.getDriverContact(),
                dto.getDriverEmail(),
                dto.getDriverPassword(),
                "NOT ASSIGN"
        );
        driverRepo.save(drivers);
    }

    @Override
    public DriverDTO searchDrive(String driverNICNumber) {
        Optional<Drivers> drivers = driverRepo.findById(driverNICNumber);
        if (drivers.isPresent()) {
            return mapper.map(drivers.get(), DriverDTO.class);
        }
        return null;
    }


//    @Override
//    public ReturnBookingDTO getReturn(String vehicleRegID) {
//
//        ReturnBookingDTO rn=new ReturnBookingDTO();
//        rn.setBookingID("fsf");
//        rn.setBookingDetails(null);
//        return rn;


//        Booking b = bookingRepo.getReturn(vehicleRegID);
//        System.out.println("RETURN = " + b);
//        return new ReturnBookingDTO(
//                b.getBookingID(),
//                b.getRentDate(),
//                b.getRentDate(),
//                b.getCustNICNumber(),
//                b.getBookingDetails()
//        );
//        ArrayList<ReturnBookingDTO> returnBookingDTOS = new ArrayList<>();
//        List<Booking> list = bookingRepo.getReturn(vehicleRegID);
//        System.out.println("list = " + list);
//        for (Booking b : list) {
//            returnBookingDTOS.add(new ReturnBookingDTO(
//                    b.getBookingID(),
//                    b.getRentDate(),
//                    b.getRentDate(),
//                    b.getCustNICNumber(),
//                    b.getBookingDetails()
//            ));
//        }
//        return returnBookingDTOS;


//    }


    @Override
    public ArrayList<DriverDTO> getNotAssignDrivers() {
        ArrayList<DriverDTO> driverDTOS = new ArrayList<>();
        List<Drivers> list = driverRepo.getNotAssignDrivers();
        for (Drivers d : list) {
            driverDTOS.add(new DriverDTO(
                    d.getDriverNICNumber()
            ));
        }
        return driverDTOS;
    }


    @Override
    public BookingDetailsDTO getReturns(String vehicleRegID) {

        BookingDetails b = detailsRepo.findByVehicleRegID(vehicleRegID);
        return new BookingDetailsDTO(
                b.getBookingDetailsID(),
                b.getLossDamage(),
                b.getLossDamageImage(),
                b.getBookingID(),
                b.getVehicleRegID(),
                b.getDriverNICNumber()
        );

    }


    @Override
    public ArrayList<CustomDTO> getReturn(String vehicleRegID) {
        ArrayList<Object[]> list = bookingRepo.getReturn(vehicleRegID);
        ArrayList<CustomDTO> all = new ArrayList<>();
        for (Object[] o : list) {
            System.out.println(Arrays.toString(o));
            all.add(new CustomDTO(
                    o[0].toString(),
                    o[1].toString(),
                    o[2].toString(),
                    o[3].toString(),
                    Double.parseDouble(o[4].toString()),
                    o[5].toString(),
                    o[6].toString()

            ));
        }

        System.out.println("Final = " + list);
        return all;
    }

    

    @Override
    public void updateDriverStatus(DriverDTO d) {
        Drivers byId = driverRepo.findById(d.getDriverNICNumber()).get();
        byId.setDriverStatus("ASSIGN");
        driverRepo.save(byId);
    }


}




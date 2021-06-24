package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.BookingDetailsDTO;
import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Vehicle;
import com.zenixo.spring.repo.BookingDetailsRepo;
import com.zenixo.spring.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService {
    @Autowired
    BookingDetailsRepo detailsRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public ArrayList<BookingDetailsDTO> getBookingVehicle(String bookingID) {
//        ArrayList<BookingDetailsDTO> list = new ArrayList<>();
//        List<BookingDetails> b = detailsRepo.findAllByIds(bookingID);
////        System.out.println("BOOKING DETAILS = " + b);
//        for (BookingDetails details : b) {
//            list.add(new BookingDetailsDTO(
//                     details.getVehicleRegID().getVehicleRegID()
//            ));
//
//        }
//        System.out.println("BOOKING DETAILS = " + list);
//        return list;
        return null;
    }


//
//          if (bookingDetails.isPresent()) {
//        return mapper.map(bookingDetails.get(), BookingDetailsDTO.class);
//    }
//        return null;
//


//    @Override
//    public ArrayList<BookingDetailsDTO> getBookingVehicle(String bookingID) {
//        ArrayList<BookingDetailsDTO> list = new ArrayList<>();
//        List<BookingDetails> b = detailsRepo.findAllById(bookingID);
//        for (BookingDetails details : b) {
//            list.add(new BookingDetailsDTO(
//                    details.getBookingDetailsID(),
//                    details.getLossDamage(),
//                    details.getLossDamageImage(),
//                    details.getBookingID(),
//                    details.getVehicleRegID()
//            ));
//        }
//        return list;
//    }
}

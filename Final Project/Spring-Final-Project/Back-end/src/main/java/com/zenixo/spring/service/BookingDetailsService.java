package com.zenixo.spring.service;

import com.zenixo.spring.dto.BookingDetailsDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public interface BookingDetailsService {
    ArrayList<BookingDetailsDTO> getBookingVehicle(String bookingID);
}

package com.zenixo.spring.service;

import com.zenixo.spring.dto.BookingAccreptDTO;
import com.zenixo.spring.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {
    void addBooking(BookingDTO bookingDTO);

    ArrayList<BookingAccreptDTO> getPendingRent();

    void updatePend(BookingDTO dto);

    void updateVehicle(BookingDTO dto);

    void updateReject(BookingDTO dto);

    BookingDTO searchBooking(String bookingID);
}

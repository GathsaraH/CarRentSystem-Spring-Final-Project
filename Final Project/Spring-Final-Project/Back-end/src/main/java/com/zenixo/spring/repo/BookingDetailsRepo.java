package com.zenixo.spring.repo;

import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails, String> {

    @Query(value = "select * from bookingdetails where bookingID=?1 ", nativeQuery = true)
    Optional<Objects[]> getBooking(String bookingID);

    @Query(value = "select * from bookingdetails where bookingID=? ", nativeQuery = true)
    List<BookingDetails> findAllByIds(String bookingID);


//    BookingDetails findByVehicleRegIDs(Vehicle vehicleRegID);


    @Query("from BookingDetails bd where bd.vehicleRegID.vehicleRegID=:id")
    BookingDetails findByVehicleRegID(@Param("id") String id);




}

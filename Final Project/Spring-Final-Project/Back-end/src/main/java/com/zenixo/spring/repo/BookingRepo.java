package com.zenixo.spring.repo;

import com.zenixo.spring.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface BookingRepo extends JpaRepository<Booking, String> {

    @Query(value = "select b.bookingID,b.bookingStatus,b.rentDate,b.returnDate,b.custNICNumber,b.rentStatus,rd.driverNICNumber,rd.vehicleRegID from  booking b,bookingdetails rd where (b.bookingID=rd.bookingID) and b.bookingStatus='Not Approved';", nativeQuery = true)
    ArrayList<Booking> getPendingRent();

//    @Query(value = "select b.bookingID,b.rentDate,b.returnDate,b.custNICNumber,b.bookingStatus,rd.lossDamage,rd.driverNICNumber,rd.vehicleRegID from Booking b,BookingDetails rd where (b.bookingID=rd.bookingID) and b.bookingStatus='Rejected' && rd.vehicleRegID=?1", nativeQuery = true)
//    Booking getReturn(String vehicleRegID);

//    @Query(value = "select b.bookingID,b.rentDate,b.returnDate,b.custNICNumber,b.bookingStatus,rd.lossDamage,rd.driverNICNumber,rd.vehicleRegID from Booking b,BookingDetails rd where (b.bookingID=rd.bookingID) and b.bookingStatus='Rejected' && rd.vehicleRegID=?1", nativeQuery = true)
//

    @Query(value = "SELECT b.bookingID, b.rentDate, b.returnDate, b.custNICNumber.custNICNumber, bd.lossDamage, bd.driverNICNumber.driverNICNumber, bd.vehicleRegID.vehicleRegID FROM Booking b INNER JOIN b.bookingDetails bd  WHERE bd.vehicleRegID.vehicleStatus='OnUse' AND bd.vehicleRegID.vehicleRegID=:vehicleRegID")
    ArrayList<Object[]>  getReturn(@Param("vehicleRegID") String vehicleRegID);


}

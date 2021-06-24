package com.zenixo.spring.repo;

import com.zenixo.spring.dto.VehicleDTO;
import com.zenixo.spring.entity.BookingDetails;
import com.zenixo.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query(value = "update vehicle set vehicleStatus='ASSIGN' where vehicleRegID=?1", nativeQuery = true)
    public void updateStatusForRent(String vehicleRegID);

    @Query(value = "select * from vehicle where vehicleStatus='Free'",nativeQuery = true)
    ArrayList<Vehicle> getNotAssignVehicle();

    @Query("from Vehicle bd where bd.vehicleRegID=:vehicleRegID")
    Vehicle findByVehicleRegID(@Param("vehicleRegID") String vehicleRegID);



}

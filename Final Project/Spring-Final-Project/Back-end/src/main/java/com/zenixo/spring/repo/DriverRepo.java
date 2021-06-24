package com.zenixo.spring.repo;

import com.zenixo.spring.entity.Booking;
import com.zenixo.spring.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface DriverRepo extends JpaRepository<Drivers, String> {


    @Query(value = "select * from drivers where driverStatus='NOT ASSIGN'", nativeQuery = true)
    ArrayList<Drivers> getNotAssignDrivers();


    @Query(value = "update drivers set driverStatus='ASSIGN' where driverNICNumber=?1", nativeQuery = true)
    void updateStatusForDriver(String driverNICNumber);




}

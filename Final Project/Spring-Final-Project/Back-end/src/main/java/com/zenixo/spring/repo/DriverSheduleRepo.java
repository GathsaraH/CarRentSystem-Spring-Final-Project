package com.zenixo.spring.repo;

import com.zenixo.spring.entity.DriverSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface DriverSheduleRepo extends JpaRepository<DriverSchedule, String> {

    @Query("from DriverSchedule bd where bd.driverNICNumber.driverNICNumber=:driverNICNumber")
    List<DriverSchedule> findByDriverNICNumber(@Param("driverNICNumber") String driverNICNumber);

}

package com.zenixo.spring.repo;

import com.zenixo.spring.entity.VehicleSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleScheduleRepo extends JpaRepository<com.zenixo.spring.entity.VehicleSchedule, String> {

    @Query("from VehicleSchedule bd where bd.vehicleRegID.vehicleRegID=:vehicleRegID")
    VehicleSchedule findByVehicleRegID(@Param("vehicleRegID") String vehicleRegID);
}

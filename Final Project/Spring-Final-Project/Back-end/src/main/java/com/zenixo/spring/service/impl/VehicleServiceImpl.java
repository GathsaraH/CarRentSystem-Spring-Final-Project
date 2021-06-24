package com.zenixo.spring.service.impl;

import com.zenixo.spring.dto.VehicleDTO;
import com.zenixo.spring.dto.VehicleIDDTO;
import com.zenixo.spring.entity.Vehicle;
import com.zenixo.spring.exception.ValidateException;
import com.zenixo.spring.repo.VehicleRepo;
import com.zenixo.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public void addVehicle(VehicleDTO dto) {
        System.out.println("dto impl = " + dto);
        if (vehicleRepo.existsById(dto.getVehicleRegID())) {
            throw new ValidateException("Customer Already Exist");
        }
        vehicleRepo.save(mapper.map(dto, Vehicle.class));
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() {
        List<Vehicle> all = vehicleRepo.getNotAssignVehicle();
        System.out.println("Test +  " + all);
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void updateVehicle(VehicleIDDTO dto) {
//        for (VehicleIDDTO dto1 : dto.getVehicleRegID()) {
//            Vehicle vehicle = vehicleRepo.findById(dto1.getVehicleRegID() + "").get();
//            vehicle.setVehicleStatus("OnUse");
//            vehicleRepo.save(vehicle);
//        }
    }


    @Override
    public VehicleDTO getReturns(String vehicleRegID) {
        Vehicle v = vehicleRepo.findByVehicleRegID(vehicleRegID);
        System.out.println("v = " + v);
        return new VehicleDTO(
                v.getVehicleRegID(),
                v.getVehicleMainBrand(),
                v.getVehicleDailyRate(),
                v.getVehicleMonthlyRate(),
                v.getVehicleFreeKMDay(),
                v.getVehicleFreeKMMONTH(),
                v.getVehicleExtraKmPrice()
        );
    }
}

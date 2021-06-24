package com.zenixo.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicleRegID;

    private String vehicleMainBrand;

    private String vehicleSubBrand;

    private String vehicleType;

    private String vehicleFontImage;
    private String vehicleBackImage;

    private double vehicleDailyRate;
    private double vehicleMonthlyRate;


    private double vehicleExtraKmPrice;

    private String vehicleStatus;

    private double vehicleLostDamage;

    private double vehicleFreeKMDay;

    private double vehicleFreeKMMONTH;

    public VehicleDTO(String vehicleRegID, String vehicleMainBrand, double vehicleDailyRate, double vehicleMonthlyRate, double vehicleExtraKmPrice, double vehicleFreeKMDay, double vehicleFreeKMMONTH) {
        this.vehicleRegID = vehicleRegID;
        this.vehicleMainBrand = vehicleMainBrand;
        this.vehicleDailyRate = vehicleDailyRate;
        this.vehicleMonthlyRate = vehicleMonthlyRate;
        this.vehicleExtraKmPrice = vehicleExtraKmPrice;
        this.vehicleFreeKMDay = vehicleFreeKMDay;
        this.vehicleFreeKMMONTH = vehicleFreeKMMONTH;
    }


}

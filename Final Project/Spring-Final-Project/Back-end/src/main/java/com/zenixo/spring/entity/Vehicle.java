package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    private String vehicleRegID;
    private String vehicleMainBrand;
    private String vehicleSubBrand;
    private String vehicleType;
    private String vehicleFuelType;
    private String vehicleFontImage;
    private String vehicleBackImage;
    private double vehicleDailyRate;
    private double vehicleMonthlyRate;
    private String vehicleFreeMiles;
    private double vehicleExtraKmPrice;
    private String vehicleStatus;
    private double vehicleLostDamage;
    private double vehicleFreeKMDay;
    private double vehicleFreeKMMONTH;


    public Vehicle(String vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }



    //    @OneToMany(mappedBy = "vehicleRegID", cascade = {CascadeType.ALL})
//    private List<Booking> bookings;

//    @OneToMany(mappedBy = "vRegID", cascade = {CascadeType.ALL})
//    private List<BookingDetails> bookingDetails=new ArrayList<>();


//    {
//        "vRegID":"HH-7527",
//            "vMainBrand":"Audi",
//            "vSubBrand":"A1",
//            "Type":: "Luxry",
//            "vNumberOfPassage":"6",
//            "vTransmissionType":"Auto",
//            "vFuelType":"Desel",
//            "vColor":"Black",
//            "vDailyRate":"400",
//            "vMonthlyRate":"500",
//            "vFreeMiles":"2",
//            "vExtraKmPrice":"8000"
//
//    }


    public Vehicle(String vehicleRegID, String vehicleMainBrand, double vehicleDailyRate, double vehicleMonthlyRate, double vehicleExtraKmPrice, double vehicleFreeKMDay, double vehicleFreeKMMONTH) {
        this.vehicleRegID = vehicleRegID;
        this.vehicleMainBrand = vehicleMainBrand;
        this.vehicleDailyRate = vehicleDailyRate;
        this.vehicleMonthlyRate = vehicleMonthlyRate;
        this.vehicleExtraKmPrice = vehicleExtraKmPrice;
        this.vehicleFreeKMDay = vehicleFreeKMDay;
        this.vehicleFreeKMMONTH = vehicleFreeKMMONTH;
    }
}

package com.zenixo.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String custNICNumber;
    private String custName;
    private String custAddress;
    private String custNICImage;
    private String custDrivingImage;
    private String custDrivingNumber;
    private String custContact;
    private String custEmail;
    private String custPassword;
    private String custStatus;

    public CustomerDTO(String custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    //    public CustomerDTO() {
//    }
//
//    public CustomerDTO(String custNICNumber, String custName, String custAddress, String custImage) {
//        this.custNICNumber = custNICNumber;
//        this.custName = custName;
//        this.custAddress = custAddress;
//        this.custImage = custImage;
//    }
//
//    public String getCustNICNumber() {
//        return custNICNumber;
//    }
//
//    public void setCustNICNumber(String custNICNumber) {
//        this.custNICNumber = custNICNumber;
//    }
//
//    public String getCustName() {
//        return custName;
//    }
//
//    public void setCustName(String custName) {
//        this.custName = custName;
//    }
//
//    public String getCustAddress() {
//        return custAddress;
//    }
//
//    public void setCustAddress(String custAddress) {
//        this.custAddress = custAddress;
//    }
//
//    public String getCustImage() {
//        return custImage;
//    }
//
//    public void setCustImage(String custImage) {
//        this.custImage = custImage;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerDTO{" +
//                "custNICNumber='" + custNICNumber + '\'' +
//                ", custName='" + custName + '\'' +
//                ", custAddress='" + custAddress + '\'' +
//                ", custImage='" + custImage + '\'' +
//                '}';
//    }


    public CustomerDTO(String custEmail, String custPassword) {
        this.custEmail = custEmail;
        this.custPassword = custPassword;
    }


}

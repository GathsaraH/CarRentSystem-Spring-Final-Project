package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
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




    public Customer(String custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    public Customer(String custEmail, String custPassword) {
        this.custEmail = custEmail;
        this.custPassword = custPassword;

    }
}

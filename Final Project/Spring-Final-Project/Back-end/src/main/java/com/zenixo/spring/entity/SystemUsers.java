package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SystemUsers {
    @Id
    private String sysID;
    private String sysName;
    private String sysEmail;
    private String sysPassword;



//    {
//      "sysID":"S001",
//      "sysName":"Gathsara",
//      "sysEmail":"umeshgathsara@gmail.com",
//      "sysPassword":"123456789"
//    }
}

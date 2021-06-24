package com.zenixo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custMessageID;
    private String statusHead;
    private String statusMessage;
    private String customerEmail;
    @ManyToOne
    @JoinColumn(name = "custNICNumber", referencedColumnName = "custNICNumber")
    private Customer custNICNumber;

    public CustomerMessage(String statusHead, String statusMessage, String customerEmail, Customer custNICNumber) {
        this.statusHead = statusHead;
        this.statusMessage = statusMessage;
        this.customerEmail = customerEmail;
        this.custNICNumber = custNICNumber;
    }
}

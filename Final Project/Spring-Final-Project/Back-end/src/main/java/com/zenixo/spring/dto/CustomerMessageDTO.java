package com.zenixo.spring.dto;

import com.zenixo.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerMessageDTO {
    private int custMessageID;
    private String statusHead;
    private String statusMessage;
    private String customerEmail;
    private Customer custNICNumber;

    public CustomerMessageDTO(String statusHead, String statusMessage, String customerEmail, Customer custNICNumber) {
        this.statusHead = statusHead;
        this.statusMessage = statusMessage;
        this.customerEmail = customerEmail;
        this.custNICNumber = custNICNumber;
    }
}

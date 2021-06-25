package com.zenixo.spring.dto;

import com.zenixo.spring.entity.Customer;

public class ForGetCustMsgDTO {
    Customer custNICNumber;

    public ForGetCustMsgDTO(Customer custNICNumber) {
        this.custNICNumber = custNICNumber;
    }

    public ForGetCustMsgDTO() {
    }

    public Customer getCustNICNumber() {
        return custNICNumber;
    }

    public void setCustNICNumber(Customer custNICNumber) {
        this.custNICNumber = custNICNumber;
    }
}

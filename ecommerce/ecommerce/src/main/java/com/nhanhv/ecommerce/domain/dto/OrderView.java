package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

@Data
public class OrderView {
    private Long id;
    private String address;
    private Long customerId;
    private String amount;
    private String description;
    private String orderDate;
}

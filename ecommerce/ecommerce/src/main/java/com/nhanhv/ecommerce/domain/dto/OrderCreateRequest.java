package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderCreateRequest {

    @NotBlank
    private Long customerId;
    private String amount;
    private String address;
    private String description;
}

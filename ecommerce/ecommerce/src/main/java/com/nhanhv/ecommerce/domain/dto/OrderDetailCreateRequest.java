package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderDetailCreateRequest {

    @NotBlank
    private Long orderId;
    @NotBlank
    private Long productId;
    private String discount;
    private Integer quantity;
    private String unitPrice;
}

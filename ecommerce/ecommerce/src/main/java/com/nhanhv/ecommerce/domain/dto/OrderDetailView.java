package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

@Data
public class OrderDetailView {
    private Long id;
    private Long orderId;
    private Long productId;
    private String discount;
    private Integer quantity;
    private String unitPrice;
}

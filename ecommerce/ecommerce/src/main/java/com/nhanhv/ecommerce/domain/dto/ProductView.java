package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProductView {
    private String id;

    private UserView creator;
    private LocalDateTime createdAt;

    private String name;
    private String amount;
    private String price;
}

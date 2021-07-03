package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {

    @NotNull
    private String name;
    private Long categoryId;
    private String description;
    private String discount;
    private String image;
    private String available;
    private String productDate;
    private String quantity;
    private String special;
    private String unitPrice;
}

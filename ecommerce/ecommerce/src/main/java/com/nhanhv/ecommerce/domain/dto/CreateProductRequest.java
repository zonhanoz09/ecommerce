package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {

    @NotNull
    private String name;
    private String amount;
    private String price;
}

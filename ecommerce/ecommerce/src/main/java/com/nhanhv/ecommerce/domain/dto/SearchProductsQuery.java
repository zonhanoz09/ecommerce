package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

@Data
public class SearchProductsQuery {

    private Long id;

    private String name;
    private String amount;
    private String price;
}

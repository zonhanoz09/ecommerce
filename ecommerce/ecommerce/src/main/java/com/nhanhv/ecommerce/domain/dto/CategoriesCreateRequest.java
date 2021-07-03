package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
@Data
public class CategoriesCreateRequest {

    @NotBlank
    private String name;
}

package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String id;
    private String username;
    private String token;

}

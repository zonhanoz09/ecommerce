package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class UserLoginResponse {
    private String id;
    private String username;
    private String token;
    private Collection role;

}

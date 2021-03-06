package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class CreateUserRequest {

    @NotBlank @Email
    private String username;
    @NotBlank
    private String password;
    private String amount;
    @NotBlank
    private String rePassword;
    private Set<String> authorities;

}

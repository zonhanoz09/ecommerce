package com.nhanhv.ecommerce.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class CreateCustomerRequest {

        @NotBlank
        @Email
        private String username;
        @NotBlank
        private String password;
        private Number amount;
        @NotBlank
        private String repassword;
        private String role;
}

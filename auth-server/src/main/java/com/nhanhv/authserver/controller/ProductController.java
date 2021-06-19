package com.nhanhv.authserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    @GetMapping(value = { "", "/" })
    public String getProducts() {
        return "Nhan";
    }


}
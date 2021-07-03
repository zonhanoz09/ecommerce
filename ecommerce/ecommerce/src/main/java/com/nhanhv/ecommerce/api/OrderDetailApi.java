package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.service.OrderDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "OrderDetail")
@RestController
@RequestMapping(path = "api/public/order-detail")
@RequiredArgsConstructor
public class OrderDetailApi {

    private final OrderDetailService orderDetailService;

    //@RolesAllowed(Role.ADMIN)
    @PostMapping
    public OrderDetailView create(@RequestBody @Valid OrderDetailCreateRequest request) {
        return orderDetailService.create(request);
    }

    @GetMapping("{id}")
    public OrderDetailView get(@PathVariable Long id) {
        return orderDetailService.getOrderDetail(id);
    }

    @GetMapping
    public ListResponse<OrderDetailView> getOrderDetails() {
        return new ListResponse<>(orderDetailService.getOrderDetails());
    }
}

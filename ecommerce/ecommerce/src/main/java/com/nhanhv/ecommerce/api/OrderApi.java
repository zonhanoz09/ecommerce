package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.service.CategoriesService;
import com.nhanhv.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Order")
@RestController
@RequestMapping(path = "api/public/order")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderService orderService;

    //@RolesAllowed(Role.ADMIN)
    @PostMapping
    public OrderView create(@RequestBody @Valid OrderCreateRequest request) {
        return orderService.create(request);
    }

    @GetMapping("{id}")
    public OrderView get(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping
    public ListResponse<OrderView> getOrders() {
        return new ListResponse<>(orderService.getOrders());
    }
}

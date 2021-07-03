package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.OrderView;
import com.nhanhv.ecommerce.domain.model.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderView toOrderView(Orders orders);
    List<OrderView> toOrdersView(List<Orders> orders);
}
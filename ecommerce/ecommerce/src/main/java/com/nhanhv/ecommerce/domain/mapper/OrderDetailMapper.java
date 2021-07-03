package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.OrderDetailView;
import com.nhanhv.ecommerce.domain.dto.OrderView;
import com.nhanhv.ecommerce.domain.model.OrderDetails;
import com.nhanhv.ecommerce.domain.model.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    OrderDetailView toOrderDetailView(OrderDetails orders);
    List<OrderDetailView> toOrderDetailsView(List<OrderDetails> orders);
}
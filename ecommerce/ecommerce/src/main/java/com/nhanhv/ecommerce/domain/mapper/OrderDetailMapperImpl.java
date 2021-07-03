package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.OrderDetailView;
import com.nhanhv.ecommerce.domain.model.OrderDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {
    @Override
    public OrderDetailView toOrderDetailView(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }
        OrderDetailView orderDetailView = new OrderDetailView();
        orderDetailView.setId(orderDetails.getId());
        orderDetailView.setOrderId(orderDetails.getOrderId());
        orderDetailView.setProductId(orderDetails.getProductId());
        orderDetailView.setDiscount(orderDetails.getDiscount());
        orderDetailView.setQuantity(orderDetails.getQuantity());
        orderDetailView.setUnitPrice(orderDetails.getUnitPrice());
        return orderDetailView;
    }

    @Override
    public List<OrderDetailView> toOrderDetailsView(List<OrderDetails> orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }

        List<OrderDetailView> list = new ArrayList<>( orderDetails.size() );
        for ( OrderDetails order : orderDetails ) {
            list.add( toOrderDetailView( order ) );
        }

        return list;
    }
}

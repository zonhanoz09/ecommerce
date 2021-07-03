package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.OrderView;
import com.nhanhv.ecommerce.domain.model.Orders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderView toOrderView(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        OrderView orderView = new OrderView();
        orderView.setId(orders.getId());
        orderView.setCustomerId(orders.getCustomerId());
        orderView.setOrderDate( orders.getOrderDate());
        orderView.setAddress( orders.getAddress());
        orderView.setAmount( orders.getAmount());
        orderView.setDescription( orders.getDescription());
        return orderView;
    }

    @Override
    public List<OrderView> toOrdersView(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderView> list = new ArrayList<OrderView>( orders.size() );
        for ( Orders order : orders ) {
            list.add( toOrderView( order ) );
        }

        return list;
    }
}

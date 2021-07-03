package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.OrderDetailCreateRequest;
import com.nhanhv.ecommerce.domain.dto.OrderDetailView;
import com.nhanhv.ecommerce.domain.mapper.OrderDetailMapper;
import com.nhanhv.ecommerce.domain.model.OrderDetails;
import com.nhanhv.ecommerce.repository.OrderDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Transactional
    public OrderDetailView create(OrderDetailCreateRequest request) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(request.getOrderId());
        orderDetails.setProductId(request.getProductId());
        orderDetails.setDiscount(request.getDiscount());
        orderDetails.setQuantity(request.getQuantity());
        orderDetails.setUnitPrice(request.getUnitPrice());
        return orderDetailMapper.toOrderDetailView( orderDetailRepo.save(orderDetails));
    }

    @Transactional
    public OrderDetailView getOrderDetail(Long id) {
        return orderDetailMapper.toOrderDetailView( orderDetailRepo.getById(id) );
    }

    @Transactional
    public List<OrderDetailView> getOrderDetails() {
        return orderDetailMapper.toOrderDetailsView(orderDetailRepo.findAll());
    }

}

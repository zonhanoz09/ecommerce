package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.CategoriesCreateRequest;
import com.nhanhv.ecommerce.domain.dto.CategoriesView;
import com.nhanhv.ecommerce.domain.dto.OrderCreateRequest;
import com.nhanhv.ecommerce.domain.dto.OrderView;
import com.nhanhv.ecommerce.domain.mapper.CategoriesMapper;
import com.nhanhv.ecommerce.domain.mapper.OrderMapper;
import com.nhanhv.ecommerce.domain.model.Categories;
import com.nhanhv.ecommerce.domain.model.Orders;
import com.nhanhv.ecommerce.repository.CategoriesRepo;
import com.nhanhv.ecommerce.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    @Autowired
    private OrderMapper orderMapper;
    @Transactional
    public OrderView create(OrderCreateRequest request) {
        Orders orders = new Orders();
        orders.setAddress(request.getAddress());
        orders.setAmount(request.getAmount());
        orders.setCustomerId(request.getCustomerId());
        orders.setDescription(request.getDescription());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        orders.setOrderDate(formatter.format(date));
        return orderMapper.toOrderView( orderRepo.save(orders));
    }

    @Transactional
    public OrderView getOrder(Long id) {
        return orderMapper.toOrderView( orderRepo.getById(id) );
    }

    @Transactional
    public List<OrderView> getOrders() {
        return orderMapper.toOrdersView(orderRepo.findAll());
    }

}

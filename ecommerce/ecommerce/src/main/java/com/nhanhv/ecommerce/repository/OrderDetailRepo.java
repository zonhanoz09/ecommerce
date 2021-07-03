package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.OrderDetails;
import com.nhanhv.ecommerce.domain.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Long> {

    default OrderDetails getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(OrderDetails.class, id));
    }

    List<OrderDetails> findAllById(Iterable<Long> ids);
}
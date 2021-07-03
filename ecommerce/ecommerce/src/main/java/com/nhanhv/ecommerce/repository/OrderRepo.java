package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.Categories;
import com.nhanhv.ecommerce.domain.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

    default Orders getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(Orders.class, id));
    }

    List<Orders> findAllById(Iterable<Long> ids);
}
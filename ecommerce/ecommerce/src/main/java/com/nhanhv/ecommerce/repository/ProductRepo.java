package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.dto.Page;
import com.nhanhv.ecommerce.domain.dto.SearchProductsQuery;
import com.nhanhv.ecommerce.domain.dto.SearchUsersQuery;
import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.Product;
import com.nhanhv.ecommerce.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    default Product getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(Product.class, id));
    }

    List<Product> findAllById(Iterable<Long> ids);

//    @Query("SELECT u.id,u.name,u.amount,u.price FROM Product u WHERE u.name = : name")
//    //@Query("SELECT u FROM User u WHERE u.username = :username")
//    List<Product> searchProducts(@Param("name") String name);

    List<Product> findProductsByNameContains(String name);

}
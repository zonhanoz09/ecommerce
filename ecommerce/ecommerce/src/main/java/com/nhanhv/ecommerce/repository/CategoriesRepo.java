package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {

    default Categories getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(Categories.class, id));
    }

    List<Categories> findAllById(Iterable<Long> ids);
}
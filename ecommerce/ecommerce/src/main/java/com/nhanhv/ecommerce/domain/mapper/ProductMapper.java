package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductView toProductView(Product category);
    List<ProductView> toProductsView(List<Product> products);
}
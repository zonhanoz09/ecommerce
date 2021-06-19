package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductView toProductView(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductView productView = new ProductView();

        productView.setName( product.getName() );
        productView.setId( product.getId().toString() );
        productView.setPrice( product.getPrice() );
        productView.setAmount( product.getAmount() );

        return productView;
    }

    @Override
    public List<ProductView> toProductsView(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductView> list = new ArrayList<ProductView>( products.size() );
        for ( Product product : products ) {
            list.add( toProductView( product ) );
        }

        return list;
    }
}

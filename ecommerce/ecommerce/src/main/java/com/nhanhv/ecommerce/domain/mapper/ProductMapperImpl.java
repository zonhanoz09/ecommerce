package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.CreateProductRequest;
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

        productView.setId( product.getId());
        productView.setName( product.getName());
        productView.setAvailable( product.getAvailable());
        productView.setCategoryId( product.getCategoryId());
        productView.setDescription( product.getDescription());
        productView.setDiscount( product.getDiscount());
        productView.setImage( product.getImage());
        productView.setProductDate( product.getProductDate());
        productView.setQuantity( product.getQuantity());
        productView.setSpecial( product.getSpecial());
        productView.setUnitPrice( product.getUnitPrice());
        productView.setViewCount( product.getViewCount());

        return productView;
    }

    @Override
    public Product toProduct(CreateProductRequest createProductRequest) {
        if ( createProductRequest == null ) {
            return null;
        }

        Product product = new Product();
        product.setName( createProductRequest.getName());
        product.setAvailable( createProductRequest.getAvailable());
        product.setCategoryId( createProductRequest.getCategoryId());
        product.setDescription( createProductRequest.getDescription());
        product.setDiscount( createProductRequest.getDiscount());
        product.setImage( createProductRequest.getImage());
        product.setProductDate( createProductRequest.getProductDate());
        product.setQuantity( createProductRequest.getQuantity());
        product.setSpecial( createProductRequest.getSpecial());
        product.setUnitPrice( createProductRequest.getUnitPrice());
        return product;
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

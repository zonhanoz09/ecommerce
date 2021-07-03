package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.mapper.ProductMapper;
import com.nhanhv.ecommerce.domain.model.Product;
import com.nhanhv.ecommerce.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;


    @Transactional
    public ProductView create(CreateProductRequest request) {
        return productMapper.toProductView( productRepo.save( productMapper.toProduct(request)) );
    }

    @Transactional
    public ProductView update(Long id, EditProductRequest request) {
        Product product = productRepo.getById(id);
        product.setName(request.getName());
        product.setAvailable(request.getAvailable());
        product.setCategoryId(request.getCategoryId());
        product.setDescription(request.getDescription());
        product.setDiscount(request.getDiscount());
        product.setImage(request.getImage());
        product.setQuantity(request.getQuantity());
        product.setSpecial(request.getSpecial());
        product.setUnitPrice(request.getUnitPrice());
        return productMapper.toProductView(productRepo.save(product));
    }

    @Transactional
    public ProductView delete(Long id) {
        Product product = productRepo.getById(id);
        productRepo.delete(product);
        return productMapper.toProductView(product);
    }

    public ProductView getProduct(Long id) {
        Product product = productRepo.getById(id);
        return productMapper.toProductView( product );
    }

    public List<ProductView> getProducts() {
        List<Product> products = productRepo.findAll();
        return productMapper.toProductsView(products);
    }
//
//    public List<BookView> getAuthorBooks(ObjectId authorId) {
//        Author author = authorRepo.getById(authorId);
//        return bookViewMapper.toBookView(bookRepo.findAllById(author.getBookIds()));
//    }
//
    public List<ProductView> searchProducts(Page page, SearchProductsQuery query) {
        return productMapper.toProductsView(productRepo.findProductsByNameContains(query.getName()));
    }
}

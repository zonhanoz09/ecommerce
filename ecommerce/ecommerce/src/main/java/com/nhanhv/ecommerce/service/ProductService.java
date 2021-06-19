package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.CreateProductRequest;
import com.nhanhv.ecommerce.domain.dto.Page;
import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.dto.SearchProductsQuery;
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
        Product product = new Product();
        product.setName(request.getName());
        product.setAmount(request.getAmount());
        product.setPrice(request.getPrice());

        return productMapper.toProductView( productRepo.save(product) );
    }
//
//    @Transactional
//    public BookView update(ObjectId id, EditBookRequest request) {
//        Book book = bookRepo.getById(id);
//        bookEditMapper.update(request, book);
//
//        book = bookRepo.save(book);
//        if (!CollectionUtils.isEmpty(request.getAuthorIds())) {
//            updateAuthors(book);
//        }
//
//        return bookViewMapper.toBookView(book);
//    }
//
//    private void updateAuthors(Book book) {
//        List<Author> authors = authorRepo.findAllById(book.getAuthorIds());
//        authors.forEach(author -> author.getBookIds().add(book.getId()));
//        authorRepo.saveAll(authors);
//    }
//
//    @Transactional
//    public BookView delete(ObjectId id) {
//        Book book = bookRepo.getById(id);
//
//        bookRepo.delete(book);
//
//        return bookViewMapper.toBookView(book);
//    }
//
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

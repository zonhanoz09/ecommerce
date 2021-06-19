package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.CreateProductRequest;
import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Product;
import com.nhanhv.ecommerce.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    @Transactional
    public ProductView create(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setAmount(request.getAmount());
        product.setPrice(request.getPrice());

        product = productRepo.save(product);
        ProductView productView = new ProductView();
        productView.setId(product.getId().toString());
        productView.setName(product.getName());
        productView.setAmount(product.getAmount());
        productView.setPrice(product.getPrice());

        return productView;
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
    public ProductView getBook(Long id) {
        Product product = productRepo.getById(id);
        ProductView productView = new ProductView();
        productView.setId(product.getId().toString());
        productView.setName(product.getName());
        productView.setAmount(product.getAmount());
        productView.setPrice(product.getPrice());
        return productView;
    }
//
//    public List<BookView> getBooks(Iterable<ObjectId> ids) {
//        List<Book> books = bookRepo.findAllById(ids);
//        return bookViewMapper.toBookView(books);
//    }
//
//    public List<BookView> getAuthorBooks(ObjectId authorId) {
//        Author author = authorRepo.getById(authorId);
//        return bookViewMapper.toBookView(bookRepo.findAllById(author.getBookIds()));
//    }
//
//    public List<BookView> searchBooks(Page page, SearchBooksQuery query) {
//        return bookViewMapper.toBookView(bookRepo.searchBooks(page, query));
//    }
}

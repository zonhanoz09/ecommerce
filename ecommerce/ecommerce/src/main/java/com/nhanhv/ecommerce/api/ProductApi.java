package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.CreateProductRequest;
import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Role;
import com.nhanhv.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Tag(name = "Product")
@RestController
@RequestMapping(path = "api/public/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @RolesAllowed(Role.USER_ADMIN)
    @PostMapping
    public ProductView create(@RequestBody @Valid CreateProductRequest request) {
        return productService.create(request);
    }

//    @RolesAllowed(Role.BOOK_ADMIN)
//    @PutMapping("{id}")
//    public BookView edit(@PathVariable String id, @RequestBody @Valid EditBookRequest request) {
//        return bookService.update(new ObjectId(id), request);
//    }

//    @RolesAllowed(Role.BOOK_ADMIN)
//    @DeleteMapping("{id}")
//    public BookView delete(@PathVariable String id) {
//        return bookService.delete(new ObjectId(id));
//    }
//
    @GetMapping("{id}")
    public ProductView get(@PathVariable Long id) {
        return productService.getBook(id);
    }
//
//    @GetMapping("{id}/author")
//    public ListResponse<AuthorView> getAuthors(@PathVariable String id) {
//        return new ListResponse<>(authorService.getBookAuthors(new ObjectId(id)));
//    }
//
//    @PostMapping("search")
//    public ListResponse<BookView> search(@RequestBody @Valid SearchRequest<SearchBooksQuery> request) {
//        return new ListResponse<>(bookService.searchBooks(request.getPage(), request.getQuery()));
//    }
}

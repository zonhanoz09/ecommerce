package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.model.Role;
import com.nhanhv.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Tag(name = "Product")
@RestController
@RequestMapping(path = "api/public/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @RolesAllowed(Role.ADMIN)
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
        return productService.getProduct(id);
    }

    @GetMapping
    public ListResponse<ProductView> getProducts() {
        return new ListResponse<>(productService.getProducts());
    }

    @PostMapping("search")
    public ListResponse<ProductView> search(@RequestBody @Valid SearchRequest<SearchProductsQuery> request) {
        return new ListResponse<>(productService.searchProducts(request.getPage(), request.getQuery()));
    }
}

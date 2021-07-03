package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.model.Role;
import com.nhanhv.ecommerce.service.CategoriesService;
import com.nhanhv.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Tag(name = "Category")
@RestController
@RequestMapping(path = "api/public/category")
@RequiredArgsConstructor
public class CategoryApi {

    private final CategoriesService categoriesService;

    //@RolesAllowed(Role.ADMIN)
    @PostMapping
    public CategoriesView create(@RequestBody @Valid CategoriesCreateRequest request) {
        return categoriesService.create(request);
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
    public CategoriesView get(@PathVariable Long id) {
        return categoriesService.getCategory(id);
    }

    @GetMapping
    public ListResponse<CategoriesView> getCategories() {
        return new ListResponse<>(categoriesService.getCategories());
    }
}

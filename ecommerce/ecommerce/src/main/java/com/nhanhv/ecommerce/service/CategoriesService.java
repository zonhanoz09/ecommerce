package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.mapper.CategoriesMapper;
import com.nhanhv.ecommerce.domain.mapper.ProductMapper;
import com.nhanhv.ecommerce.domain.model.Categories;
import com.nhanhv.ecommerce.domain.model.Product;
import com.nhanhv.ecommerce.repository.CategoriesRepo;
import com.nhanhv.ecommerce.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesRepo categoriesRepo;
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Transactional
    public CategoriesView create(CategoriesCreateRequest request) {
        Categories categories = new Categories();
        categories.setName(request.getName());
        return categoriesMapper.toCategoryView( categoriesRepo.save(categories));
    }

    @Transactional
    public CategoriesView getCategory(Long id) {
        return categoriesMapper.toCategoryView( categoriesRepo.getById(id) );
    }

    @Transactional
    public List<CategoriesView> getCategories() {
        return categoriesMapper.toCategoriesView(categoriesRepo.findAll());
    }

}

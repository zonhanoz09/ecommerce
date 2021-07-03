package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.CategoriesView;
import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Categories;
import com.nhanhv.ecommerce.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    CategoriesView toCategoryView(Categories category);
    List<CategoriesView> toCategoriesView(List<Categories> categories);
}
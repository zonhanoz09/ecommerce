package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.CategoriesView;
import com.nhanhv.ecommerce.domain.dto.ProductView;
import com.nhanhv.ecommerce.domain.model.Categories;
import com.nhanhv.ecommerce.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesMapperImpl implements CategoriesMapper {

    @Override
    public CategoriesView toCategoryView(Categories category) {
        if ( category == null ) {
            return null;
        }
        CategoriesView categoryView = new CategoriesView();
        categoryView.setName( category.getName());
        categoryView.setId( category.getId());
        return categoryView;
    }

    @Override
    public List<CategoriesView> toCategoriesView(List<Categories> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoriesView> list = new ArrayList<CategoriesView>( categories.size() );
        for ( Categories category : categories ) {
            list.add( toCategoryView( category ) );
        }

        return list;
    }
}

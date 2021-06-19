package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.dto.Page;
import com.nhanhv.ecommerce.domain.dto.SearchProductsQuery;
import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, ProductCustom {

    default Product getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(Product.class, id));
    }

    List<Product> findAllById(Iterable<Long> ids);

}

interface ProductCustom {

    //List<Product> searchProducts(Page page, SearchProductsQuery query);

}

@RequiredArgsConstructor
class ProductRepoCustomImpl implements ProductCustom {


    //@Override
    //public List<Product> searchProducts(Page page, SearchProductsQuery query) {
//        List<AggregationOperation> operations = new ArrayList<>();
//
//        List<Criteria> criteriaList = new ArrayList<>();
//        if (!StringUtils.isEmpty(query.getId())) {
//            criteriaList.add(Criteria.where("id").is(new ObjectId(query.getId())));
//        }
//        if (!StringUtils.isEmpty(query.getCreatorId())) {
//            criteriaList.add(Criteria.where("creatorId").is(new ObjectId(query.getCreatorId())));
//        }
//        if (query.getCreatedAtStart() != null) {
//            criteriaList.add(Criteria.where("createdAt").gte(query.getCreatedAtStart()));
//        }
//        if (query.getCreatedAtEnd() != null) {
//            criteriaList.add(Criteria.where("createdAt").lt(query.getCreatedAtEnd()));
//        }
//        if (!StringUtils.isEmpty(query.getTitle())) {
//            criteriaList.add(Criteria.where("title").regex(query.getTitle(), "i"));
//        }
//        if (!CollectionUtils.isEmpty(query.getGenres())) {
//            criteriaList.add(Criteria.where("genres").all(query.getGenres()));
//        }
//        if (!StringUtils.isEmpty(query.getIsbn13())) {
//            criteriaList.add(Criteria.where("isbn13").is(query.getIsbn13()));
//        }
//        if (!StringUtils.isEmpty(query.getIsbn10())) {
//            criteriaList.add(Criteria.where("isbn10").is(query.getIsbn10()));
//        }
//        if (!StringUtils.isEmpty(query.getPublisher())) {
//            criteriaList.add(Criteria.where("publisher").regex(query.getPublisher(), "i"));
//        }
//        if (query.getPublishDateStart() != null) {
//            criteriaList.add(Criteria.where("publishDate").gte(query.getPublishDateStart()));
//        }
//        if (query.getPublishDateEnd() != null) {
//            criteriaList.add(Criteria.where("publishDate").lt(query.getPublishDateEnd()));
//        }
//        if (!criteriaList.isEmpty()) {
//            Criteria bookCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[0]));
//            operations.add(match(bookCriteria));
//        }
//
//        criteriaList = new ArrayList<>();
//        if (!StringUtils.isEmpty(query.getAuthorId())) {
//            criteriaList.add(Criteria.where("author._id").is(new ObjectId(query.getAuthorId())));
//        }
//        if (!StringUtils.isEmpty(query.getAuthorFullName())) {
//            criteriaList.add(Criteria.where("author.fullName").regex(query.getAuthorFullName(), "i"));
//        }
//        if (!criteriaList.isEmpty()) {
//            Criteria authorCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[0]));
//            operations.add(lookup("authors", "authorIds", "_id", "author"));
//            operations.add(unwind("author", false));
//            operations.add(match(authorCriteria));
//        }
//
//        operations.add(sort(Sort.Direction.DESC, "createdAt"));
//        operations.add(skip((page.getNumber() - 1) * page.getLimit()));
//        operations.add(limit(page.getLimit()));
//
//        TypedAggregation<Book> aggregation = newAggregation(Book.class, operations);
//        System.out.println(aggregation.toString());
//        AggregationResults<Book> results = mongoTemplate.aggregate(aggregation, Book.class);
//        return results.getMappedResults();
       // return null;
   // }


}


package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.domain.dto.Page;
import com.nhanhv.ecommerce.domain.dto.SearchUsersQuery;
import com.nhanhv.ecommerce.domain.exception.NotFoundException;
import com.nhanhv.ecommerce.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository @CacheConfig(cacheNames = "users")
public interface UserRepo extends UserRepoCustom, JpaRepository<User, ObjectId> {

    @CacheEvict(allEntries = true)
    <S extends User> List<S> saveAll(Iterable<S> entities);

    @Caching(evict = {
            @CacheEvict(key = "#p0.id"),
            @CacheEvict(key = "#p0.username")
    })
    <S extends User> S save(S entity);

    @Cacheable
    Optional<User> findById(Long objectId);

    @Cacheable
    default User getById(Long id) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(User.class, id);
        }
        if (!optionalUser.get().isEnabled()) {
            throw new NotFoundException(User.class, id);
        }
        return optionalUser.get();
    }

    @Cacheable
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

}

interface UserRepoCustom {

    List<User> searchUsers(Page page, SearchUsersQuery query);

}

@RequiredArgsConstructor
class UserRepoCustomImpl implements UserRepoCustom {

    //private final MongoTemplate mongoTemplate;

    @Override
    public List<User> searchUsers(Page page, SearchUsersQuery query) {
//        List<AggregationOperation> operations = new ArrayList<>();
//
//        List<Criteria> criteriaList = new ArrayList<>();
//        if (!StringUtils.isEmpty(query.getId())) {
//            criteriaList.add(Criteria.where("id").is(new ObjectId(query.getId())));
//        }
//        if (!StringUtils.isEmpty(query.getUsername())) {
//            criteriaList.add(Criteria.where("username").regex(query.getUsername(), "i"));
//        }
//        if (!StringUtils.isEmpty(query.getFullName())) {
//            criteriaList.add(Criteria.where("fullName").regex(query.getFullName(), "i"));
//        }
//        if (!criteriaList.isEmpty()) {
//            Criteria userCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[0]));
//            operations.add(match(userCriteria));
//        }
//
//        operations.add(sort(Sort.Direction.DESC, "createdAt"));
//        operations.add(skip((page.getNumber() - 1) * page.getLimit()));
//        operations.add(limit(page.getLimit()));
//
//        TypedAggregation<User> aggregation = newAggregation(User.class, operations);
//        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
//        return results.getMappedResults();
        return null;
    }
}

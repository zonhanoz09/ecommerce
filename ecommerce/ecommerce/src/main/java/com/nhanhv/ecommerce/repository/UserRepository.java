package com.nhanhv.ecommerce.repository;

import com.nhanhv.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("select distinct u from User as u "
            + "where u.username = ?1")
    User Login (String username);

    @Query("select distinct u from User as u "
            + "where u.id = ?1")
    User findAll(Integer id);
}


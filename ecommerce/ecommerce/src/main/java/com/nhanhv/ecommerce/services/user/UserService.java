package com.nhanhv.ecommerce.services.user;

import com.nhanhv.ecommerce.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    List<User> listUser();
    User getById (Integer id);
    User createUser (User user) throws NoSuchAlgorithmException;
    User Login (String username, String password);
}

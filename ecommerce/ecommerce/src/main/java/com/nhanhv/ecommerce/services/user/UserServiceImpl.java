package com.nhanhv.ecommerce.services.user;

import com.nhanhv.ecommerce.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhanhv.ecommerce.model.User;
import com.nhanhv.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.inject.Inject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUser() {
        logger.info("this is log example");
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(null);
        }
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findAll(id);
    }

    @Override
    public User createUser(User user){
        user.setPassword(UserUtils.getMd5(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User Login(String username, String password) {
        User user = userRepository.Login(username);
        if (user.getPassword().equals(UserUtils.getMd5(password)))
        {
            user.setPassword(null);
            return user;
        }
        return null;
    }
}

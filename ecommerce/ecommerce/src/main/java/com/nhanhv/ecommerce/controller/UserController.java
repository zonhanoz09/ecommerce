package com.nhanhv.ecommerce.controller;

import com.nhanhv.ecommerce.exception.ResourceNotFoundException;
import com.nhanhv.ecommerce.model.User;
import com.nhanhv.ecommerce.model.request.UserLogin;
import com.nhanhv.ecommerce.repository.UserRepository;
import com.nhanhv.ecommerce.services.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public List<User> getAllEmployees() {
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") int userId)
    {
        User user = userService.getById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("")
    public User createEmployee(@Valid @RequestBody User user) throws NoSuchAlgorithmException {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public User createEmployee(@Valid @RequestBody UserLogin userLogin) {
        User user = userService.Login(userLogin.getUsername(),userLogin.getPassword());
        if (user == null ) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }
        return user;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Integer userId,
                                                     @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setName(userDetails.getName());
        user.setAmount(userDetails.getAmount());
        final User productUpdate = userRepository.save(user);
        return ResponseEntity.ok(productUpdate);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
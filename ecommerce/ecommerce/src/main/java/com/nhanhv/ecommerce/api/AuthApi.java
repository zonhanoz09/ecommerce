package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.configuration.security.JwtTokenUtil;
import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.mapper.UserMapper;
import com.nhanhv.ecommerce.domain.model.User;
import com.nhanhv.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Tag(name = "Authentication")
@RestController @RequestMapping(path = "api/public")
@RequiredArgsConstructor
public class AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            User user = (User) authenticate.getPrincipal();
            userMapper.toUserLoginView(user);
            UserLoginResponse userView = userMapper.toUserLoginView(user);
            userView.setToken(jwtTokenUtil.generateAccessToken(user));
            userView.setRole(user.getAuthorities());
            return ResponseEntity.ok()
                    .body(userView);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public UserView register(@RequestBody @Valid CreateUserRequest request) {
        return userService.create(request);
    }

    @PostMapping("user/create")
    public UserView create(@RequestBody @Valid CreateCustomerRequest request) {

        CreateUserRequest createUserRequest = new CreateUserRequest();

        Set<String> roles_ = new HashSet<>();
        createUserRequest.setUsername(request.getUsername());
        createUserRequest.setAmount(request.getAmount().toString());
        createUserRequest.setPassword(request.getPassword());
        createUserRequest.setRePassword(request.getRepassword());
        roles_.add(request.getRole());
        createUserRequest.setAuthorities(roles_);
        return userService.create(createUserRequest);
    }

}

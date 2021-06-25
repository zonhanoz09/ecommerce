package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.configuration.security.JwtTokenUtil;
import com.nhanhv.ecommerce.domain.dto.AuthRequest;
import com.nhanhv.ecommerce.domain.dto.CreateUserRequest;
import com.nhanhv.ecommerce.domain.dto.UserLoginResponse;
import com.nhanhv.ecommerce.domain.dto.UserView;
import com.nhanhv.ecommerce.domain.mapper.UserMapper;
import com.nhanhv.ecommerce.domain.model.User;
import com.nhanhv.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}

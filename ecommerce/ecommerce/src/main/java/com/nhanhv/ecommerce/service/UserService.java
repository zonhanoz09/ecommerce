package com.nhanhv.ecommerce.service;

import com.nhanhv.ecommerce.domain.dto.CreateUserRequest;
import com.nhanhv.ecommerce.domain.dto.UserView;
import com.nhanhv.ecommerce.domain.mapper.ProductMapper;
import com.nhanhv.ecommerce.domain.mapper.UserMapper;
import com.nhanhv.ecommerce.domain.model.Role;
import com.nhanhv.ecommerce.domain.model.User;
import com.nhanhv.ecommerce.repository.RoleRepo;
import com.nhanhv.ecommerce.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepository;
    @Autowired
    private UserMapper userMapper;
    //private final UserViewMapper userViewMapper;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public UserView create(CreateUserRequest request) {

        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            throw new ValidationException("Username exists!");
        }
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new ValidationException("Passwords don't match!");
        }
        if (request.getAuthorities() == null) {
            request.setAuthorities(new HashSet<>());
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());
        var roles_ = new ArrayList<Role>();
        for (String item : request.getAuthorities()) {
            roles_.add(roleRepository.findByName(item));
        }
        user.setRoles(roles_);
        return userMapper.toUserView(userRepo.save(user));
    }
//
//    @Transactional
//    public UserView update(ObjectId id, UpdateUserRequest request) {
//        User user = userRepo.getById(id);
//        userEditMapper.update(request, user);
//
//        user = userRepo.save(user);
//
//        return userViewMapper.toUserView(user);
//    }

//    @Transactional
//    public UserView upsert(CreateUserRequest request) {
//        Optional<User> optionalUser = userRepo.findByUsername(request.getUsername());
//
//        if (optionalUser.isEmpty()) {
//            return create(request);
//        } else {
//            UpdateUserRequest updateUserRequest = new UpdateUserRequest();
//            updateUserRequest.setFullName(request.getFullName());
//            return update(optionalUser.get().getId(), updateUserRequest);
//        }
//    }

//    @Transactional
//    public UserView delete(ObjectId id) {
//        User user = userRepo.getById(id);
//
//        user.setUsername(user.getUsername().replace("@", String.format("_%s@", user.getId().toString())));
//        user.setEnabled(false);
//        user = userRepo.save(user);
//
//        return userViewMapper.toUserView(user);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        User user = userRepo.getUserByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//
//        return new MyUserDetails(user);
//    }

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepo
//                .findByUsername(username)
//                .orElseThrow(
//                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
//                );
//    }

    @Override
    public UserDetails loadUserByUsername(String username)
             {

        User user = userRepo.getUserByUsername(username);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
        }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getRoles(roles));
    }

    private List<String> getRoles(Collection<Role> roles) {

        List<String> roles_ = new ArrayList<>();
        for (Role item : roles) {
            roles_.add(item.getName());
        }
        return roles_;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

//    public boolean usernameExists(String username) {
//        return userRepo.findByUsername(username).isPresent();
//    }
//
    public UserView getUser(Long id) {
        return userMapper.toUserView(userRepo.getById(id));
    }

    public List<UserView> getUsers() {
        return userMapper.toUsersView(userRepo.findAll());
    }
//
//    public List<UserView> searchUsers(Page page, SearchUsersQuery query) {
//        List<User> users = userRepo.searchUsers(page, query);
//        return userViewMapper.toUserView(users);
//    }

}

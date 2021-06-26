package com.nhanhv.ecommerce.api;

import com.nhanhv.ecommerce.domain.dto.*;
import com.nhanhv.ecommerce.domain.model.Role;
import com.nhanhv.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "UserAdmin")
@RestController @RequestMapping(path = "api/admin/user")
@RolesAllowed(Role.ADMIN)
@RequiredArgsConstructor
public class UserAdminApi {

    private final UserService userService;

//    @PostMapping
//    public UserView create(@RequestBody @Valid CreateUserRequest request) {
////        return userService.create(request);
//    return null;
//    }

//    @PutMapping("{id}")
//    public UserView update(@PathVariable String id, @RequestBody @Valid UpdateUserRequest request) {
//        return userService.update(new ObjectId(id), request);
//    }
//
//    @DeleteMapping("{id}")
//    public UserView delete(@PathVariable String id) {
//        return userService.delete(new ObjectId(id));
//    }
//
    @GetMapping("{id}")
    public UserView get(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("")
    public List<UserView> getUsers() {
        return userService.getUsers();
    }


//    @PostMapping("search")
//    public ListResponse<UserView> search(@RequestBody SearchRequest<SearchUsersQuery> request) {
//        return new ListResponse<>(userService.searchUsers(request.getPage(), request.getQuery()));
//    }

}

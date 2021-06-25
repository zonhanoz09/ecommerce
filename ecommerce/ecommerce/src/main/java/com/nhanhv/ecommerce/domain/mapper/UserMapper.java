package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.UserLoginResponse;
import com.nhanhv.ecommerce.domain.dto.UserView;
import com.nhanhv.ecommerce.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserView toUserView(User user);
    UserLoginResponse toUserLoginView(User user);
    List<UserView> toUsersView(List<User> users);
}

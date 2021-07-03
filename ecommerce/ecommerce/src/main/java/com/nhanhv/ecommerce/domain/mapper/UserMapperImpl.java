package com.nhanhv.ecommerce.domain.mapper;

import com.nhanhv.ecommerce.domain.dto.UserLoginResponse;
import com.nhanhv.ecommerce.domain.dto.UserView;
import com.nhanhv.ecommerce.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserView toUserView(User user) {
        if (user == null ) {
            return null;
        }
        UserView userView = new UserView();
        userView.setId( user.getId().toString());
        userView.setUsername( user.getUsername());
        userView.setAmount( user.getAmount());
        return userView;
    }

    @Override
    public UserLoginResponse toUserLoginView(User user) {
        if (user == null ) {
            return null;
        }
        UserLoginResponse userView = new UserLoginResponse();
        userView.setId( user.getId().toString());
        userView.setUsername( user.getUsername());
        return userView;
    }

    @Override
    public List<UserView> toUsersView(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserView> list = new ArrayList<UserView>( users.size() );
        for ( User user : users ) {
            list.add( toUserView( user ) );
        }

        return list;
    }
}

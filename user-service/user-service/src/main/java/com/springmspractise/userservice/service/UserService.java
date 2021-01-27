package com.springmspractise.userservice.service;

import com.springmspractise.userservice.entity.User;
import com.springmspractise.userservice.model.UserDetails;

public interface UserService {
    UserDetails getUserDetails(Long userId);

    User addUser(User user);

    User getUser(Long id);

}

package com.rupesh.service;

import com.rupesh.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User updateUserById(Long id, User newUser);

    String deleteUserById(Long id);
}

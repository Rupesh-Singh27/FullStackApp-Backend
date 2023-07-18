package com.rupesh.serviceImpl;

import com.rupesh.exception.UserNotFoundException;
import com.rupesh.model.User;
import com.rupesh.repository.UserRepository;
import com.rupesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No User with ID: " + id, "NOT_FOUND"));
        return user;
    }

    @Override
    public User updateUserById(Long id, User newUser) {
        return userRepository.findById(id)
                .map((user) -> {
                    user.setName(newUser.getName());
                    user.setUserName(newUser.getUserName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException("No User with id: " + id, "NOT_FOUND"));
    }


    @Override
    public String deleteUserById(Long id) {

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("No user with id: " + id, "NOT_FOUND");
        }

        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted";
    }
}

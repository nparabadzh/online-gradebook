package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.User;
import com.example.onlinegradebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void addUser(@ModelAttribute User user) {
        userRepository.save(user);
    }

    public User findUserById(@PathVariable("id") int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return user;
    }

    public void updateUser(@ModelAttribute User user) throws Exception {
        User userInDB = userRepository.findById(user.getId()).orElse(null);
        if (userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setEGN(user.getEGN());
            userInDB.setAddress(user.getAddress());
            userInDB.setRole(user.getRole());
            userRepository.save(userInDB);
        } else {
            throw new Exception("User not found");
        }
    }

    public void deleteUser(@PathVariable("id") int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
    }
}

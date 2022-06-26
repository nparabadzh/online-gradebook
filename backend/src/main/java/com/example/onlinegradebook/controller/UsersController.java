package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.User;
import com.example.onlinegradebook.model.UserPost;
import com.example.onlinegradebook.model.UserRoleAssociation;
import com.example.onlinegradebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.onlinegradebook.controller.UsersController.USERS_CONTROLLER_ENDPOINT;

@RestController
@RequestMapping(path = USERS_CONTROLLER_ENDPOINT)
public class UsersController {

    public static final String USERS_CONTROLLER_ENDPOINT = "/api/v1/users";

    @Autowired
    private UserRepository userRepo;

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(UserPost userPost){
        User user = new User(UUID.randomUUID().toString(),
                userPost.getUsername(),
                BCrypt.hashpw(userPost.getPassword(), BCrypt.gensalt(10)),
                userPost.getFirstName(),
                userPost.getLastName());
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping(path = "/user/role")
    public ResponseEntity<User> assignRole(UserPost userPost){
        // TODO
         User user = new User(UUID.randomUUID().toString(), userPost.getUsername(), BCrypt.hashpw(userPost.getPassword(), BCrypt.gensalt(10)),userPost.getFirstName(), userPost.getLastName());
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(path = "/userInfo")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        User user = userRepo.findByUsername("system.admin");
        if (userDetails != null) {
            UserRoleAssociation userRoleAssociation = user.getUserRoleAssociation().iterator().next();
            String name = userRoleAssociation.getUserRoleAssociationKey().getRole().getName();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

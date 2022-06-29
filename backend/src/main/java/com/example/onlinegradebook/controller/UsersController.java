package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.*;
import com.example.onlinegradebook.repositories.UserRepository;
import com.example.onlinegradebook.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.onlinegradebook.controller.UsersController.USERS_CONTROLLER_ENDPOINT;

@RestController
@RequestMapping(path = USERS_CONTROLLER_ENDPOINT)
public class UsersController {

    public static final String USERS_CONTROLLER_ENDPOINT = "/api/users";
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userServices;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/user")
    public ResponseEntity<?> createUser(@RequestBody UserPost userPost){
        if(userRepo.existsByEmail(userPost.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userPost.getPassword());
        User user = new User(
                userPost.getEmail(),
                encodedPassword,
                userPost.getFirstName(),
                userPost.getLastName(),
                userPost.getEgn(),
                userPost.getAddress(),
                userPost.getRole());
        userRepo.save(user);
        JSONObject userInfo = new JSONObject();
        userInfo.put("email", user.getEmail());
        userInfo.put("firstName", user.getFirstName());
        userInfo.put("lastName", user.getLastName());
        userInfo.put("EGN", user.getEGN());
        userInfo.put("role", user.getRole());
        userInfo.put("address", user.getAddress());
        JSONObject resp = new JSONObject();
        resp.put("message", "Created");
        resp.put("user", userInfo);
        return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepo.findByEmail(loginDto.getEmail());
        JSONObject userInfo = new JSONObject();
        userInfo.put("email", user.getEmail());
        userInfo.put("firstName", user.getFirstName());
        userInfo.put("lastName", user.getLastName());
        userInfo.put("EGN", user.getEGN());
        userInfo.put("role", user.getRole());
        userInfo.put("roles", user.getRoles());
        JSONObject resp = new JSONObject();
        resp.put("message", "logged in");
        resp.put("user", userInfo);
        return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(Model model) {
        List<User> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping(path = "/user/role")
    public ResponseEntity<User> assignRole(UserPost userPost){
        // TODO
         User user = new User(UUID.randomUUID().toString(), userPost.getEmail(), BCrypt.hashpw(userPost.getPassword(), BCrypt.gensalt(10)),userPost.getFirstName(), userPost.getLastName());
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(path = "/userInfo")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        User user = userRepo.findByEmail(userDetails.getUsername());
        if (userDetails != null) {
            RoleEntity role = user.getRoles().iterator().next();
            String name = role.getName();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}

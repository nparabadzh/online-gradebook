package com.example.onlinegradebook.service;

import com.example.onlinegradebook.model.Role;
import com.example.onlinegradebook.model.Users;
import com.example.onlinegradebook.repository.RoleRepository;
import com.example.onlinegradebook.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Users saveUser(Users user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(true);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        Users user = findUserByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
        return null;// new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                user.getActive(), true, true, true, authorities);
    }

}
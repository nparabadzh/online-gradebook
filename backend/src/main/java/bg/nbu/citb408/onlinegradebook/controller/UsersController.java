package bg.nbu.citb408.onlinegradebook.controller;

import bg.nbu.citb408.onlinegradebook.model.User;
import bg.nbu.citb408.onlinegradebook.model.UserRoleAssociation;
import bg.nbu.citb408.onlinegradebook.repositories.UserRepository;
import bg.nbu.citb408.onlinegradebook.model.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static bg.nbu.citb408.onlinegradebook.controller.UsersController.USERS_CONTROLLER_ENDPOINT;

@Controller
@RequestMapping(path = USERS_CONTROLLER_ENDPOINT)
public class UsersController {

    public static final String USERS_CONTROLLER_ENDPOINT = "/api/v1/users";

    @Autowired
    private UserRepository userRepo;

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(@RequestBody UserPost userPost){
        User user = new User(/*UUID.randomUUID().toString(),*/
                userPost.getUsername(),
                userPost.getPassword(),
//                BCrypt.hashpw(userPost.getPassword(), BCrypt.gensalt(10)),
                userPost.getFirstName(),
                userPost.getLastName());
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping(path = "/user/role")
    public ResponseEntity<User> assignRole(UserPost userPost){
        // TODO
         User user = new User(/*UUID.randomUUID().toString(),*/ userPost.getUsername(), BCrypt.hashpw(userPost.getPassword(), BCrypt.gensalt(10)),userPost.getFirstName(), userPost.getLastName());
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

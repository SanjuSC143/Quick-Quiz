package com.example.QuickQuizServer.Controller;

import com.example.QuickQuizServer.Entity.Role;
import com.example.QuickQuizServer.Entity.User;
import com.example.QuickQuizServer.Entity.UserRole;
import com.example.QuickQuizServer.Service.UserService;
import com.example.QuickQuizServer.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/")
    //creating user
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        //encoding password with BcryptPasswordEncoder
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Set<UserRole> roles =new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);

    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }
    //delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

}

package com.example.QuickQuizServer.Controller;

import com.example.QuickQuizServer.Entity.JwtRequest;
import com.example.QuickQuizServer.Entity.JwtResponse;
import com.example.QuickQuizServer.Entity.User;
import com.example.QuickQuizServer.Service.impl.UserDetailsServiceImpl;
import com.example.QuickQuizServer.config.JwtUtils;
import com.example.QuickQuizServer.helper.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch(UserNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String s = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(s));
    }
    private void authenticate(String username,String password) throws Exception {
        try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e){
            throw new Exception("User DISABLED"+e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials"+e.getMessage());
        }
    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}

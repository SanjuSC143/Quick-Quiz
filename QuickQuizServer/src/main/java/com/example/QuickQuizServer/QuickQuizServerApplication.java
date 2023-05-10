package com.example.QuickQuizServer;

import com.example.QuickQuizServer.Entity.Role;
import com.example.QuickQuizServer.Entity.User;
import com.example.QuickQuizServer.Entity.UserRole;
import com.example.QuickQuizServer.Service.UserService;
import com.example.QuickQuizServer.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class QuickQuizServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {

		SpringApplication.run(QuickQuizServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
//		try {
//			User user = new User();
//
//			user.setFirstName("Sanjana");
//			user.setLastName("Choube");
//			user.setUsername("sanjana");
//			user.setPassword(this.passwordEncoder.encode("abc"));
//			user.setEmail("sanjana@gmail.com");
//			user.setProfile("default.png");
//			user.setPhone("8080155017");
//
//			Role role1 = new Role();
//			role1.setRoleId(44L);
//			role1.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role1);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//			User user1 = this.userService.createUser(user, userRoleSet);
//			System.out.println(user1.getUsername());
//		}catch(UserFoundException e){
//			e.printStackTrace();
//		}


	}
}

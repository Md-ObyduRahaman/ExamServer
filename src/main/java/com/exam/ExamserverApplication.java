package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project Running....");
		User user=new User();
		user.setFirstname("Md Obydur Rahaman");
		user.setLastname("Sojib");
		user.setEmail("Sojib.19991018@gmail.com");
		user.setPassword("123");
		user.setUsername("Sojib");
		user.setProfile("sojib.png");

		Role role=new Role();
		role.setRoleId(11L);
		role.setRoleName("Admin");

		Set<UserRole> userRoles= new HashSet<>();
		UserRole userRole=new UserRole();

		userRole.setRole(role);
		userRole.setUser(user);

		userRoles.add(userRole);
		 User userOut= this.userService.createUser(user,userRoles);
		System.out.println(userOut.getUsername());

	}
}

package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //create User
    @PostMapping("/")
    public User createUser(@RequestBody User user){

        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(12L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();

        userRole.setRole(role);
        userRole.setUser(user);

        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }
    @GetMapping("/{username}")
    public  User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }




}

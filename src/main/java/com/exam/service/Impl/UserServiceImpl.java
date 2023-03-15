package com.exam.service.Impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @SneakyThrows
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
         User local=this.userRepository.findByUserName(user.getUsername());
         if(local!=null){
             System.out.println("User is already exist");
             throw  new Exception("User already present");
         }else {



             // push from Home

         }
        return null;
    }
}

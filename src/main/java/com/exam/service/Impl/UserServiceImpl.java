package com.exam.service.Impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    //Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
         User local=this.userRepository.findByUsername(user.getUsername());
         if(local!=null){
             System.out.println("User is already exist");
          }else {

             for (UserRole ur:userRoles
                  ) {
                 roleRepository.save(ur.getRole());
             }
             user.getUserRoles().addAll(userRoles);
             local= this.userRepository.save(user);



         }
        return local;
    }
}

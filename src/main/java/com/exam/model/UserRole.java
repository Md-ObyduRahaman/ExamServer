package com.exam.model;


import jakarta.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserRoleId;

    //User
    @ManyToOne(fetch = FetchType.EAGER)
    private  User user;

    @ManyToOne
    private Role role;
}

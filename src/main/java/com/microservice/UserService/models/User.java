package com.microservice.UserService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hashedPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Roles> roles;



}

package com.ads.mangement.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id") )
    private Set<Role> roles = new HashSet<>();


}

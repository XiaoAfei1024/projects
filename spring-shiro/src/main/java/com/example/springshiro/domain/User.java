package com.example.springshiro.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

/**
 * 角色
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Role> roles;
}

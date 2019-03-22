package com.example.springshiro.domain;

import com.sun.tools.javac.util.List;
import lombok.Data;

import javax.persistence.*;


/**
 * 用户
 */
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<Permission> permissions;

}

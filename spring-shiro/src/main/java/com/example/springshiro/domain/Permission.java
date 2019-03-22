package com.example.springshiro.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *  权限
 */
@Entity
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String permission;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}

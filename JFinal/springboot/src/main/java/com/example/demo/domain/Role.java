package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/5/15/015 14:41
 * @Version 1.0
 */
@Getter
@Setter
public class Role {
    private long id;
    private String name;
    private String description;
    // 后台用户数量
    private String adminCount;
    private Date createTime;
    // 启用状态：0->禁用；1->启用
    private int status;
    private int sort;
}

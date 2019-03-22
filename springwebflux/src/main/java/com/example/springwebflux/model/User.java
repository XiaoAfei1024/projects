package com.example.springwebflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;




import java.util.Date;
@Data  // 生成无参构造方法/getter/setter/hashCode/equals/toString
@AllArgsConstructor // 生成所有参数构造方法
@Document // MongoDB是文档型的NoSQL数据库，因此，我们使用@Document注解User类
public class User {
    @Id
    private String id; // 注解属性id为ID
    @Indexed(unique = true)  // 注解属性username为索引，并且不能重复
    private String username;
    private String name;
    private String phone;
    private Date birthday;
}

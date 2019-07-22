package com.example.demo.utils;

import com.example.demo.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/5/5/005 9:32
 * @Version 1.0
 */
public class ShiroUtil {
    private static final String ENCRYPT_ALGORITHM = "md5";
    private  static final int HASH_ITERATIONS = 1;

    public static String encryptPassword(User user) {
        ByteSource salt = ByteSource.Util.bytes(user.getUserName());
        return new SimpleHash(ENCRYPT_ALGORITHM, user.getPassWord(), salt, HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("test");
        user.setPassWord("666666");
        System.out.println(encryptPassword(user));
    }
}

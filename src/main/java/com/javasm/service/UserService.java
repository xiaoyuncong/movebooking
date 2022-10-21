package com.javasm.service;

import com.javasm.pojo.Users;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-20:45
 * @Since：jdk1.8
 * @Description：
 */
public interface UserService {

    Users login(String name,String password);
}

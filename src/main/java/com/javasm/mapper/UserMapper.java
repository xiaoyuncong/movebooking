package com.javasm.mapper;

import com.javasm.pojo.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-19:22
 * @Since：jdk1.8
 * @Description：
 */
public interface UserMapper {
    Users getUserByNameAndPwd(@Param("name") String name, @Param("password") String password);
}

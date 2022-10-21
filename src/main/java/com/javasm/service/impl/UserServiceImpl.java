package com.javasm.service.impl;

import com.javasm.commons.utils.SqlSessionFactoryUtils;
import com.javasm.mapper.UserMapper;
import com.javasm.pojo.Users;
import com.javasm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-20:46
 * @Since：jdk1.8
 * @Description：
 */
public class UserServiceImpl implements UserService {
    private static SqlSessionFactory sqlSessionFactory =SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public Users login(String name, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users userByNameAndPwd = mapper.getUserByNameAndPwd(name, password);

        return userByNameAndPwd;
    }
}

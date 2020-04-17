package com.jd.service.impl;

import com.jd.domain.User;
import com.jd.dao.UserMapper;
import com.jd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:User的Service实现类
 * @CreateDate: 2020-02-05 09:36
 * @Author: wuhao
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Long id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);

    }

    @Override
    public int modifyUser(User user) {
        return userMapper.modifyUser(user);
    }

    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }

 }

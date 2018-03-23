package com.ctg.flag.service.impl;

import com.ctg.flag.dao.UserDao;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;

@Component
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User login(String openid) {
        User user = userDao.getUserByOpenid(openid);
        if (user == null) {
            user = new User();
            user.setOpenid(openid);
            userDao.save(user);
        }
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Integer userId) {
        return userDao.getUserById(userId);
    }
}

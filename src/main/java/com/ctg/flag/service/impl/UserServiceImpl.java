package com.ctg.flag.service.impl;

import com.ctg.flag.dao.UserDao;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        userDao = userDao;
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
}

package com.nehal.demo.service;

import com.nehal.demo.dao.UserDao;
import com.nehal.demo.model.User;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}

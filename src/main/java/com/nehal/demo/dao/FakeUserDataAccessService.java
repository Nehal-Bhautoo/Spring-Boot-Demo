package com.nehal.demo.dao;

import com.nehal.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeUserDataAccessService implements UserDao {

    private static List<User> userList = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        userList.add(new User(id, user.getFirstName(), user.getLastName()));
        return 1;
    }
}

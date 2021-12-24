package com.nehal.demo.dao;

import com.nehal.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static List<User> userList = new ArrayList<>();

    @Override
    public int insertUser(UUID uuid, User user) {
        userList.add(new User(uuid, user.getFirstName(), user.getLastName()));
        return 1;
    }


    @Override
    public List<User> getUser() {
        return userList;
    }
}

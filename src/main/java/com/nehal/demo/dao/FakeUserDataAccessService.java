package com.nehal.demo.dao;

import com.nehal.demo.model.User;
import com.nehal.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {
    @Autowired
    private UserRepository userRepository;

    private static List<User> userList = new ArrayList<>();

    @Override
    public int insertUser(UUID uuid, User user) {
        userList.add(new User(uuid, user.getFirstName(), user.getLastName()));
        userRepository.save(new User(uuid, user.getFirstName(), user.getLastName()));
        return 1;
    }

    @Override
    public List<User> getUser() {
        return userList;
    }
}

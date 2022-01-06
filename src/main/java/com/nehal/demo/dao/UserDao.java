package com.nehal.demo.dao;

import com.nehal.demo.model.User;
import java.util.List;
import java.util.UUID;

public interface UserDao {
    UUID id = UUID.randomUUID();
    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        return insertUser(id, user);
    }
    List<User> getUser();
}

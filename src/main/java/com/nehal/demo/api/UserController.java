package com.nehal.demo.api;

import com.nehal.demo.model.User;
import com.nehal.demo.repository.UserRepository;
import com.nehal.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
        userRepository.save(user);
    }


    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.getUser();
    }
}

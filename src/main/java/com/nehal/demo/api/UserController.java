package com.nehal.demo.api;

import com.nehal.demo.exception.ResourceNotFoundException;
import com.nehal.demo.model.User;
import com.nehal.demo.repository.UserRepository;
import com.nehal.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // create new user
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    // get all user
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User Not found" + userId));
        return ResponseEntity.ok().body(user);
    }
    
    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Integer userId,
            @RequestBody User userBody) throws ResourceNotFoundException {
        User users = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User Not found" + userId));
        users.setFirstName(userBody.getFirstName());
        users.setLastName(userBody.getLastName());
        final User updatedUser = userRepository.save(users);
        return ResponseEntity.ok(updatedUser);
    }
}

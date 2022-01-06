package com.nehal.demo.api;

import com.nehal.demo.exception.ResourceNotFoundException;
import com.nehal.demo.model.User;
import com.nehal.demo.repository.UserRepository;
import com.nehal.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nehal.demo.encryption.JasyptEncryptorUtils.encode;

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
    public void addUser(@RequestBody User userBody) {
        User user = new User();
        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        user.setPassword(encode(userBody.getPassword()));
        userService.addUser(user);
    }

    // get all user
    @GetMapping("/user")
    public List<User> getAllUsers() {
        System.out.println(userRepository.findAll().toString());
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
        users.setPassword(encode(userBody.getPassword()));
        final User updatedUser = userRepository.save(users);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete User
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User Not found" + userId));
        userRepository.delete(user);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

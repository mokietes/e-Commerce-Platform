package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.model.User;
import com.ecommerce.service.UserService;

@RestController 
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @SuppressWarnings("unchecked")
    // @GetMapping("/users")
    // public List<User> getUsers() {
    //     return (List<User>) userService.getUsers();
    // }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        Optional<User> user = userService.getUser(id);
        return user.orElse(null); 
    }

    // @PostMapping("/users")
    // public void addUser(@RequestBody User user) {
    //     userService.addUser(user);
    // }

    // @PutMapping("/users/{id}")
    // public void updateUser(@RequestBody User user, @PathVariable int id) {
    //     userService.updateUser(id, user);
    // }

    // @DeleteMapping("/users/{id}")
    // public void deleteUser(@PathVariable int id) {
    //     userService.deleteUser(id);
    // }
}

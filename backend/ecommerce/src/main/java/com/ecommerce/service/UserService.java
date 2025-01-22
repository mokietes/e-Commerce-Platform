package com.ecommerce.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.api.model.User;

@Service 
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        
        User user1 = new User(1, "John",5, "ida@mail.com");
        User user2 = new User(2, "Jane", 22, "jane@mail.com");
        User user3 = new User(3, "Doe", 30, "doe@mail.com");
        User user4 = new User(4, "Smith", 35, "smith@mail.com");
        User user5 = new User(5, "Doe", 30, "lkadfa@mail.com");
        User user6 = new User(6, "Smith", 35, "smith@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6));
    }

    public Optional<User> getUserID(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public  List<User> getAllUsers() {
        return userList;
    }

    // public User deleteUser(int id) {
    //     userList.removeIf(user -> user.getId() == id);
    //             return null;
    // }

    public void updateUser(int id, User user) {
        Optional<User> userOptional = userList.stream().filter(u -> u.getId() == id).findFirst();
        if (userOptional.isPresent()) {
            User u = userOptional.get();
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setEmail(user.getEmail());
        }
    }

    public void addUser(User user) {
        userList.add(user); 
    }
}

package com.ecommerce.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.api.model.User;

@Service 
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        User user1 = new User(id: 1, name: "John", age: 25, email: "ida@mail.com");
        User user2 = new User(id: 2, name: "Jane", age: 22, email: "jane@mail.com");
        User user3 = new User(id: 3, name: "Doe", age: 30, email: "doe@mail.com");
        User user4 = new User(id: 4, name: "Smith", age: 35, email: "smith@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public User getUser(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User getUsers () {
        return (User) userList;
    }

    public User deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
                return null;
    }

    public User updateUser(int id, User user) {
        userList.stream().filter(u -> u.getId() == id).forEach(u -> {
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setEmail(user.getEmail());
        });
                return user;
    }
}

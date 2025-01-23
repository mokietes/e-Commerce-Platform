package com.ecommerce.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ecommerce.api.model.User;
import jakarta.annotation.PostConstruct;

@Service 
public class UserService {
    // private List<User> userList;

    // public UserService() {
    //     userList = new ArrayList<>();
        
    //     User user1 = new
    //     User user2 = new User(2, "Jane", 22, "jane@mail.com");
    //     User user3 = new User(3, "Doe", 30, "doe@mail.com");
    //     User user4 = new User(4, "Smith", 35, "smith@mail.com");
    //     User user5 = new User(5, "Doe", 30, "lkadfa@mail.com");
    //     User user6 = new User(6, "Smith", 35, "smith@mail.com");

    //     userList.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6));
    // }

    private List<User> user = new ArrayList<>();

    @PostConstruct
    private void init() {
        user.add( new User(1, "Jane", 22, "jane@mail.com"));
        user.add(new User(2, "Jane", 22, "jane@mail.com"));
        user.add(new User(3, "Doe", 30, "doe@mail.com"));
        user.add(new User(4, "Smith", 35, "smith@mail.com"));
    }

    public Optional<User> getUserID(int id) {
        return user.stream().filter(user -> user.getId() == id).findFirst();
    }

    public  List<User> getAllUsers() {
        return user;
    }

    public User deleteUser(int id) {
        user.removeIf(user -> user.getId() == id);
                return null;
    }

    public void updateUser(int id, User user) {
        Optional<User> userOptional = getUserID(id);
        if (userOptional.isPresent()) {
            User userToBeUpdated = userOptional.get();
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setAge(user.getAge());
            userToBeUpdated.setEmail(user.getEmail());
        }
    }

    public void addUser(User userID) {
        user.add(userID); 
    }
}

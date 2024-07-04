package org.example;

import com.mongodb.client.MongoDatabase;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String email, String password) {
        User user = new User(email, password);
        userRepository.saveUser(user);
        System.out.println("User registered successfully.");
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user.getId();
        }
        return null;
    }
}

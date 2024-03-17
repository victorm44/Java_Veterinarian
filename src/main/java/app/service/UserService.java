package app.service;

import java.util.HashMap;
import java.util.Map;
import app.models.User;

public class UserService {
    private static final Map<String, User> users = new HashMap<>();

    public static void addUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        users.put(username, user);
    }

    public static boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }
}

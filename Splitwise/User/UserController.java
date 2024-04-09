package User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getUser(String UserId) {
        for (User user : users) {
            if (user.getUserId() == UserId) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}

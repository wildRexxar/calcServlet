package by.tms.storage;

import by.tms.entity.User;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private final static List<User> userList = new ArrayList<>();

    public boolean addUser(User user) {
        if ((findByLogin(user.getLogin()) == null) && (user.getLogin() != null && user.getPassword() != null)) {
            save(user);
            return true;
        } else {
            return false;
        }
    }

    private User findByLogin(String login) {
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User checkUser (User user) {
        User checkUser = findByLogin(user.getLogin());
        if (checkUser != null) {
            if (checkUser.getPassword().equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public boolean renameUser(String newLogin, String newPassword, User user) {
            user.setLogin(newLogin);
            user.setPassword(newPassword);
            return true;
    }


    public boolean deleteUser(int userIndex) {
            userList.remove(userIndex);
        return false;
    }


    private boolean save(User user) {
        return userList.add(user);
    }
}
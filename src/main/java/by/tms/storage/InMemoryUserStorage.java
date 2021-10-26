package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private final static List<User> userList = new ArrayList<>();
    private static int userIndex = -1;

    public boolean registration(User user) {
        if ((findByLogin(user.getLogin()) == -1) && (user.getLogin() != null && user.getPassword() != null)) {
            save(user);
            userIndex = -1;
            return true;
        } else {
            return false;
        }
    }

    public int findUser(User user) {
        User checkUser = userList.get(findByLogin(user.getLogin()));
        if (checkUser != null) {
            if (checkUser.getLogin().equals(user.getLogin()) && checkUser.getPassword().equals(user.getPassword())) {
                userIndex = userList.indexOf(user);
                return userIndex;
            }
        }
        return -1;
    }

    public boolean renameUser(String newLogin, String newPassword) {
        if(userIndex > -1) {
            User user = userList.get(userIndex);
            user.setLogin(newLogin);
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    public boolean deleteUser() {
        if (userIndex > -1) {
            userList.remove(userIndex);
            return true;
        }
        return false;
    }

    public int setDefaultUserIndex(){
       return userIndex = -1;
    }

    public int getUserIndex(){
        return userIndex;
    }

    private boolean save(User user) {
        return userList.add(user);
    }

    private int findByLogin(String login) {
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return userList.indexOf(user);
            }
        }
        return -1;
    }
}
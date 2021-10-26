package by.tms.entity;

import java.util.Objects;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString () {
        return login + " " + password;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof User) {
            User user = (User) object;
            return user.getLogin().equals(this.login) && user.getPassword().equals(this.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}

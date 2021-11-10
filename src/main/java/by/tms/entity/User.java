package by.tms.entity;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private boolean status;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, boolean status){
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String statusModification(boolean status){
        this.status = status;

        if(status == true) {
            return "admin";
        } else {
            return "user";
        }
    }

    @Override
    public String toString () {
        return "LOGIN:" + login + " PASSWORD: " + password + " STATUS: " + statusModification(status);
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

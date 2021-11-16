package by.tms.storage;

import by.tms.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static final String FIND_LOGIN = "SELECT * FROM users WHERE BINARY login LIKE ?";
    private static final String SAVE_USER = "INSERT INTO users (login, password, status) VALUE (? , ?, false )";
    private static final String GET_USER = "SELECT * FROM users WHERE BINARY login LIKE ? AND BINARY password LIKE ?";
    private static final String DELETE_ACCOUNT = "DELETE FROM users WHERE login LIKE ?";
    private static final String UPDATE_USER = "UPDATE  users SET login = ?, password = ?";
    private static final String GET_USERS = "SELECT * FROM users";
    private static final String UPDATE_USER_STATUS = "UPDATE users SET status = ? WHERE login LIKE ?";

    public boolean checkLogin(User user) {
        String login = null;
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_LOGIN)) {
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                login = resultSet.getString("login");
                return login.equals(user.getLogin());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveUserInDB(User user) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserFromDB(User user) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return findUserInDB(resultSet, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User findUserInDB(ResultSet resultSet, User user) throws SQLException {
        while (resultSet.next()) {
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            boolean status = resultSet.getBoolean("status");
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
                return new User(login, password, status);
            }
        }
        return null;
    }

    public List getAllUsersFromDB() {
        try(Connection connection = DBConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS)){
            ResultSet resultSet = preparedStatement.executeQuery();
            return getListOfUsers(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    private List getListOfUsers(ResultSet resultSet) throws SQLException{
        List<User> listOfUsers = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            boolean status = resultSet.getBoolean("status");
            listOfUsers.add(new User(login, password, status));
        }
        return listOfUsers;
    }

    public void updateUserStatus(String login, boolean status){
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_STATUS)){
            preparedStatement.setBoolean(1, status);
            preparedStatement.setString(2, login);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String login) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setString(1, login);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserInDB(String newLogin, String newPassword) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, newPassword);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
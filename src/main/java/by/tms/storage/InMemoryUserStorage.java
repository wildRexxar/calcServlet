package by.tms.storage;

import by.tms.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InMemoryUserStorage {
    private static final String findLogin = "SELECT * FROM users WHERE BINARY login LIKE ?";
    private static final String saveLogin = "INSERT INTO users (login, password) VALUE (? , ?)";
    private static final String getUser = "SELECT * FROM users WHERE BINARY login LIKE ? AND BINARY password LIKE ?";
    private static final String deleteUser = "DELETE FROM users WHERE id = ?";
    private static final String updateUser = "UPDATE  users SET login = ?, password = ? where id = ?";

    public boolean checkLogin(User user) {
        String checkLogin = null;
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(findLogin)) {
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkLogin = resultSet.getString("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkLogin == null;
    }

    public void save(User user) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(saveLogin)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int idOutput(User user) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getUser)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return getId(resultSet, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void delete(int id) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUser)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean update(String newLogin, String newPassword, int id) {
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateUser)) {
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getId(ResultSet resultSet, User user) throws SQLException {
        while (resultSet.next()) {
            int idInDB = resultSet.getInt("id");
            String loginInDB = resultSet.getString("login");
            String passwordInDB = resultSet.getString("password");
            if (loginInDB.equals(user.getLogin()) && passwordInDB.equals(user.getPassword()))
                return idInDB;
        }
        return -1;
    }
}
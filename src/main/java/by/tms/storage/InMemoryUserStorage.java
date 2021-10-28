package by.tms.storage;

import by.tms.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InMemoryUserStorage {
    private int userId;

    public boolean checkLogin(User user) {
        String findLoginInDB = "SELECT * FROM users WHERE BINARY login LIKE ?";
        String checkLogin = null;
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(findLoginInDB)) {
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

    public void addToDB(User user) {
        String writeUserInDB = "INSERT INTO users (login, password) VALUE (? , ?)";
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(writeUserInDB)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getUserFromDB(User user) {
        String getUser = "SELECT * FROM users WHERE BINARY login LIKE ? AND BINARY password LIKE ?";
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getUser)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idInDB = resultSet.getInt("id");
                String loginInDB = resultSet.getString("login");
                String passwordInDB = resultSet.getString("password");
                if (loginInDB.equals(user.getLogin()) && passwordInDB.equals(user.getPassword())) {
                    setUserId(idInDB);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setUserId(int id) {
        userId = id;
    }

    public int getUserId() {
        return userId;
    }

    public boolean deleteUserFromDB(int userId) {

        String deleteUser = "DELETE FROM users WHERE id = ?";
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUser)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUserInDB(String newLogin, String newPassword, int userId) {
        String deleteUser = "UPDATE  users SET login = ?, password = ? where id = ?;";
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUser)) {
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setInt(3, userId);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean checkForNull(String str) {
        return str != null && str.matches("[a-zA-z0-9]+");
    }
}
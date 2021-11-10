package by.tms.storage;
import by.tms.entity.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {
    private static final String SAVE_RESULT = "INSERT INTO result_history (login, num1, operation, num2, result) VALUE (?, ?, ?, ?, ?)";
    private static final String GET_RESULT = "SELECT * FROM result_history WHERE login LIKE ? ";

    public void saveResult(String login, double num1, String operation, double num2, double result){
        try(Connection connect = DBConnectionManager.connect();
            PreparedStatement preparedStatement = connect.prepareStatement(SAVE_RESULT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setDouble(2, num1);
            preparedStatement.setString(3, operation);
            preparedStatement.setDouble(4, num2);
            preparedStatement.setDouble(5, result);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List getListOfResults(String login) {
        List<Result> listOfExpressions = new ArrayList<>();
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_RESULT)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfExpressions.add(new Result(resultSet.getDouble("num1"), resultSet.getString("operation"),
                        resultSet.getDouble("num2"), resultSet.getDouble("result")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfExpressions;
    }
}
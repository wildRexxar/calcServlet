package by.tms.storage;
import by.tms.entity.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {
    private static final String saveResult = "INSERT INTO result_history (id, num1, operation, num2, result) VALUE (?, ?, ?, ?, ?)";
    private static final String getResults = "SELECT * FROM result_history WHERE id LIKE ? ";

    public void save(int id, double num1, String operation, double num2, double result){
        try(Connection connect = DBConnectionManager.connect();
            PreparedStatement preparedStatement = connect.prepareStatement(saveResult)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, num1);
            preparedStatement.setString(3, operation);
            preparedStatement.setDouble(4, num2);
            preparedStatement.setDouble(5, result);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List getResult(int id) {
        List<Result> listOfResult = new ArrayList<>();
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getResults)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfResult.add(new Result(resultSet.getDouble("num1"), resultSet.getString("operation"),
                        resultSet.getDouble("num2"), resultSet.getDouble("result")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfResult;
    }
}
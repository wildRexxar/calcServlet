package by.tms.storage;
import by.tms.entity.Expression;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryExpressionStorage {
    private static final String SAVE_EXPRESSION = "INSERT INTO result_history (id, num1, operation, num2, result) VALUE (?, ?, ?, ?, ?)";
    private static final String GET_EXPRESSIONS = "SELECT * FROM result_history WHERE login LIKE ? ";

    public void saveExpression(int id, double num1, String operation, double num2, double result){
        try(Connection connect = DBConnectionManager.connect();
            PreparedStatement preparedStatement = connect.prepareStatement(SAVE_EXPRESSION)) {
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

    public  List getExpressions(String login) {
        List<Expression> listOfExpressions = new ArrayList<>();
        try (Connection connection = DBConnectionManager.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_EXPRESSIONS)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfExpressions.add(new Expression(resultSet.getDouble("num1"), resultSet.getString("operation"),
                        resultSet.getDouble("num2"), resultSet.getDouble("result")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfExpressions;
    }
}
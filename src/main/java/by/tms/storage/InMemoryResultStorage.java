package by.tms.storage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {
    private static final String saveResult = "INSERT INTO result_history (id, expression, result) VALUE (?, ?, ?) ";
    private static final String getResults = "SELECT * FROM result_history WHERE id LIKE ? ";

    public void save(String num1, String operation, String num2, String result, int userID){
        try(Connection connect = ConnectToBase.connect();
            PreparedStatement preparedStatement = connect.prepareStatement(saveResult)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, num1 + " " + operation + " " + num2);
            preparedStatement.setString(3, result);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List getResult(int userId) {
        List<String> listOfResult = new ArrayList<>();
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getResults)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfResult.add(resultSet.getString("expression") + " = " + resultSet.getString("result"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfResult;
    }
}
package by.tms.storage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryResultStorage {

    public void writeResultToDB(String num1, String operation, String num2, String result, int userID){
        String insertResult = "INSERT INTO result_history (id, expression, result) VALUE (?, ?, ?) ";
        try(Connection connect = ConnectToBase.connect();
            PreparedStatement preparedStatement = connect.prepareStatement(insertResult)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, num1 + " " + operation + " " + num2);
            preparedStatement.setString(3, result);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List getResult(int userId) {
        String getHistoryById = "SELECT * FROM result_history WHERE id LIKE ? ";
        List<String> listOfResult = new ArrayList<>();
        try (Connection connection = ConnectToBase.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getHistoryById)) {
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
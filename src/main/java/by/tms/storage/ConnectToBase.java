package by.tms.storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToBase {
    private static final String URL = "calc";
    private static final String user = "ilya";
    private static final String password = "9708";

    public static Connection connect (){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/calc?useUnicode=true&serverTimezone=UTC" , "ilya", "9708");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
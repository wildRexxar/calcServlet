package by.tms.storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
    private static final String BASE = "calc";
    private static final String USER = "ilya";
    private static final String PASSWORD = "9708";
    private static final String URL = "jdbc:mysql://localhost/"+ BASE +"?useUnicode=true&serverTimezone=UTC";

    public static Connection connect (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
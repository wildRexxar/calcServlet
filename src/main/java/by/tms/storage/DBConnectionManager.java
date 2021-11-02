package by.tms.storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
    private static final String URL = "calc";
    private static final String user = "ilya";
    private static final String password = "9708";

    public static Connection connect (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+ URL +"?useUnicode=true&serverTimezone=UTC" , user, password);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
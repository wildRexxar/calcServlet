package by.tms.storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToBase {
    public static Connection connect (){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/calc?useUnicode=true&serverTimezone=UTC" , "ilya", "9708");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
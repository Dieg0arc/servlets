package co.edu.cue.servlets.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos";
    private static String user = "root";
    private static String password = "";
    private static Connection connection;
    public static Connection getInstance() throws SQLException {
        if(connection==null){
            connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }
}

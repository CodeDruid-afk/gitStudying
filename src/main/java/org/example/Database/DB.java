package org.example.Database;
import java.sql.*;

public class DB {
    private static final String url = "url_link";
    private static final String user = "username";
    private static final String password = "password";
    private static Connection connection;
    private DB(){}

    public static Connection getConnection(){
        if(connection==null){
            try {
                connection = DriverManager.getConnection(url,user,password);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}



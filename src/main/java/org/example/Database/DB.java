package org.example.Database;
import java.sql.*;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "2205";
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



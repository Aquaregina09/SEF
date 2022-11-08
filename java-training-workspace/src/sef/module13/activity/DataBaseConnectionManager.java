package sef.module13.activity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionManager {
    private Connection connection;
    
    public DataBaseConnectionManager() {
        try {
            Class.forName(AppConfiguration.getString("jdbc.jdbc.driver")); //$NON-NLS-1$
        
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found: " + e.getMessage()); //$NON-NLS-1$
        }
    }
    String url = AppConfiguration.getString("jdbc.jdbc.url"); //$NON-NLS-1$
    String username = AppConfiguration.getString("jdbc.jdbc.username"); //$NON-NLS-1$
    String password = AppConfiguration.getString("jdbc.jdbc.password"); //$NON-NLS-1$
    
    public Connection getConnection() throws SQLException{
//        if(connection == null) {
            connection = DriverManager.getConnection(url, username, password);
//        }
        return connection;
    }
    
    public void closeConnection() throws SQLException{
        if(connection != null) {
            connection.close();
        }
    }
}

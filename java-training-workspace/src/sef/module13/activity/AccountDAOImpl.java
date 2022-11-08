package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private static final String SELECT_ALL_ACCOUNT = "SELECT id, first_name, last_name, email FROM Account";
    private static final String SELECT_ACCOUNT_BY_FIRSTNAME_LASTNAME = SELECT_ALL_ACCOUNT + "WHERE first_name LIKE '?' AND last_name LIKE '?'";
    private static final String SELECT_ACCOUNT_BY_ID = SELECT_ALL_ACCOUNT + "WHERE id = ?";
    private static final String INSERT_ACCOUNT = "INSERT INTO Account (FIRST_NAME, LAST_NAME, E_MAIL) VALUES (?,?,?)\"";
    
//    private static final int ID_COLUMN = 1;
//    private static final int FIRST_NAME_COLUMN = 2;
//    private static final int LAST_NAME_COLUMN = 3;
//    private static final int EMAIL_COLUMN = 4;
    
//        private String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(HOST=localhost)(PORT=1521)(PROTOCOL=tcp))(CONNECT_DATA=(SERVICE_NAME=XEPDB1)))";
//        private String user = "hr";
//        private String pass = "hr";
        private Connection conn; 

    PreparedStatement statement = null;
    ResultSet rows = null;
//    private final DataBaseConnectionManager databaseConnectionManager;

    
    public AccountDAOImpl(Connection conn) {
        this.conn = conn;
    }

//    public AccountDAOImpl(DataBaseConnectionManager databaseConnectionManager) {
//        this.databaseConnectionManager = databaseConnectionManager;
//    }
    
    public List<Account> findAccount(String firstName, String lastName) throws AccountDAOException,SQLException {
        List<Account> accountList = new ArrayList<>();
        statement = conn.prepareStatement(SELECT_ACCOUNT_BY_FIRSTNAME_LASTNAME);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        rows = statement.executeQuery();
        
        if(rows.next()) {
            Account account = new AccountImpl(rows.getInt(1), rows.getString(2), rows.getString(3),rows.getString(4));
            accountList.add(account);
            
        }
        return accountList;
    }

    public Account findAccount(int id) throws AccountDAOException {
        Account account = null;
        try {
            statement = conn.prepareStatement(SELECT_ACCOUNT_BY_ID);
            statement.setInt(1, id);
            rows = statement.executeQuery();
            
            if(rows.next()) {
                account = new AccountImpl(rows.getInt(1), rows.getString(2), rows.getString(3),rows.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public boolean insertAccount(String firstName, String lastName, String email) throws AccountDAOException {
        try {
            statement = conn.prepareStatement(INSERT_ACCOUNT);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            
            statement.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

}

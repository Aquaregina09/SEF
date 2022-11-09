package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static sef.module13.activity.AccountDAOException.*;

public class AccountDAOImpl implements AccountDAO {

    private static final String SELECT_ALL_ACCOUNTS = "SELECT id, first_name, last_name, e_mail FROM account";
    private static final String SELECT_ACCOUNTS_BY_NAME = "SELECT_ALL_ACCOUNTS WHERE UPPER(first_name) LIKE UPPER(?) AND UPPER(last_name) LIKE UPPER(?) ORDER BY id";
    private static final String SELECT_ACCOUNT_BY_ID = SELECT_ALL_ACCOUNTS + " WHERE id = ?";
    private static final String INSERT_ACCOUNT = "INSERT INTO account(first_name, last_name, e_mail) VALUES (?,?,?)";

    private static final int ID_COLUMN = 1;
    private static final int FIRST_NAME_COLUMN = 2;
    private static final int LAST_NAME_COLUMN = 3;
    private static final int EMAIL_COLUMN = 4;

    private PreparedStatement statement;
    private ResultSet resultSet;

    private Connection conn;

    public AccountDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public List<Account> findAccount(String firstName, String lastName) throws AccountDAOException {

        List<Account> accounts = new ArrayList<>();

        try {
            statement = conn.prepareStatement(SELECT_ACCOUNTS_BY_NAME);

            statement.setString(1, "%" + firstName + "%");
            statement.setString(2, "%" + lastName + "%");

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = toAccount(resultSet);
                accounts.add(account);

            }
        } catch (SQLException e) {
            throw new AccountDAOException(ERROR_FIND_NAME, e);

        } finally {
            this.close();

        }

        return accounts;
    }

    public Account findAccount(int id) throws AccountDAOException {
        Account account = null;

        try {
            statement = conn.prepareStatement(SELECT_ACCOUNT_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account = toAccount(resultSet);

            }
        } catch (SQLException e) {
            throw new AccountDAOException(ERROR_FIND_ID, e);

        } finally {
            this.close();

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
            throw new AccountDAOException(ERROR_INSERT_ACCOUNT, e);

        } finally {
            this.close();

        }

    }

    private void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            logSQLException(e);
        }
    }

    private void logSQLException(SQLException e) {
        System.out.println(String.format("sql_error=%s, error_code=%s", e.getMessage(), e.getErrorCode()));
    }

    private AccountImpl toAccount(ResultSet row) throws SQLException {
        AccountImpl account = new AccountImpl(row.getInt(ID_COLUMN),
                                              row.getString(FIRST_NAME_COLUMN),
                                              row.getString(LAST_NAME_COLUMN),
                                              row.getString(EMAIL_COLUMN));
        return account;
    }

}

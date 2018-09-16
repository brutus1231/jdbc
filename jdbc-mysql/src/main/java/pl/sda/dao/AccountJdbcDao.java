package pl.sda.dao;

import java.sql.*;

public class AccountJdbcDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/zad1?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "scott";
    private static final String DB_PASS = "scott";

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void findAll() throws SQLException {
        final String query = "SELECT * FROM account";
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        showAccountResult(resultSet);
        closeConnection(connection);
    }


    public void findById(int idAccount) throws SQLException {
        final String query = "SELECT * FROM account WHERE account_id = " + idAccount;
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        showAccountResult(resultSet);
        closeConnection(connection);
    }

    public void findByNumber(String number) throws SQLException {
        final String query = "SELECT * FROM account WHERE number = " + number;
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        showAccountResult(resultSet);
        closeConnection(connection);
    }

    public void findByCreationDate(Date date) throws SQLException {
        final String query = "SELECT * FROM account WHERE creation_date = " + date;
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        showAccountResult(resultSet);
        closeConnection(connection);
    }

    public void findAfterCreationDate(Date date) throws SQLException {
        final String query = "SELECT * FROM account WHERE creation_date > " + date;
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        showAccountResult(resultSet);
        closeConnection(connection);
    }

    public void findAccountsCount() throws SQLException {
        final String query = "SELECT count(1) as licznik FROM account ";
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int licznik = resultSet.getInt("licznik");
            System.out.println("Ilość wpisów w tabeli account: " + licznik);
        }
        closeConnection(connection);
    }

    private void showAccountResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int accountId = resultSet.getInt("account_id");
            int balance = resultSet.getInt("balance");
            String number = resultSet.getString("number");
            Date creationDate = resultSet.getDate("creation_date");
            Date endDate = resultSet.getDate("end_date");
            System.out.println(accountId + ", " + balance + ", " + number + ", "
                    + creationDate.toString() + ", " + endDate.toString());
        }
    }

}

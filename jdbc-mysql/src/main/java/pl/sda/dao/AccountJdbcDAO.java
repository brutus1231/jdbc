package pl.sda.dao;

import java.sql.*;

public class AccountJdbcDAO {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/zad1?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    public static final String DB_USER = "scott";
    public static final String DB_PASS = "scott";


    Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }


    void findAll() throws SQLException {
        final String query = "SELECT * FROM account";
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Long id = resultSet.getLong("account_id");
            Integer balance = resultSet.getInt("balance");
            String number = resultSet.getString("number");
            Date creationDate = resultSet.getDate("creation_date");
            Date endDate = resultSet.getDate("end_date");
            System.out.println(id + " " + balance + " " + number + " " + creationDate + " " + endDate);
        }
        resultSet.close();
        statement.close();
        closeConnection(connection);
    }

    void findById() {
    }

    void findByNumber() {
    }

    void findByCreationDate() {
    }

    void findAllAfterCreationDate() {
    }

    void findAccountsCount() {
    }
}

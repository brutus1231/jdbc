package pl.sda.dao;

import java.sql.*;
import java.util.Scanner;

public class AccountDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/zad1?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "scott";
    private static final String DB_PASSWORD = "scott";
    private static final Scanner scanner = new Scanner(System.in);

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private ResultSet getResultSet(String query) throws SQLException {
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Long accID = resultSet.getLong("account_id");
            Long balance = resultSet.getLong("balance");
            String accNumber = resultSet.getString("number");
            String creationDate = resultSet.getString("creation_date");
            String endDate = resultSet.getString("end_date");
            System.out.println(accID + " " + balance + " " + accNumber + " " + creationDate + " "
                    + endDate);
        }
        resultSet.close();
        statement.close();
        return resultSet;
    }

    void findAll() throws SQLException {
        final String query = "SELECT * FROM account";
        getResultSet(query);
    }

    void findById() throws SQLException {
        System.out.println("Podaj ID: ");
        int idToFind = scanner.nextInt();
        final String query = "SELECT * FROM account WHERE account_id = " + idToFind;
        getResultSet(query);
    }

    void findByNumber() throws SQLException {
        System.out.println("Podaj numer karty: ");
        String numberToFind = scanner.nextLine();
        final String query = "SELECT * FROM account WHERE number = " + numberToFind;
        getResultSet(query);

    }

    void findByCreationDate() {
        System.out.println("Podaj date: ");
        String dateToFind = scanner.nextLine();
        final String query = "SELECT * FROM account WHERE number = " + dateToFind;
    }

    void findAllAfterCreationDate() {

    }

    void findSize() throws SQLException {
        int size = 0;
        final String query = "SELECT * FROM account";
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            size++;
        }
        System.out.println(size);
    }
}

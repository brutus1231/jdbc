package pl.sda.dao;

import pl.sda.dto.AccountDto;

import java.sql.*;

public class AccountDaoImpl {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/zad1?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "scott";
    private static final String PASS = "scott";
    private static final String SEPARATOR = ", ";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    void findAll() throws SQLException {
        String query = "select * from account";

        createStatement(query);
    }

    void findByCreationDate(String creationDate) throws SQLException {
        String query = "select * from account where date(creation_date) = ?";
        findByQuery(query, creationDate);
    }


    void findAllAfterCreationDate(String creationDate) throws SQLException {
        String query = "select * from account where date(creation_date) > ?";
        findByQuery(query, creationDate);
    }

    void findAccountsCount() throws SQLException {
        String query = "select count(1) as liczba_kont from account";
        createStatement(query);
    }

    private void createStatement(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        printResults(query, resultSet);
    }

    private void findByQuery(String query, String param1) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, param1);
        ResultSet resultSet = preparedStatement.executeQuery();
        printResults(query, resultSet);
    }

    private void printResults(String query, ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        while (resultSet.next()) {
            String result = "";
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                result += resultSet.getString(i) + SEPARATOR;
            }
            System.out.println(removeSeparator(result));
        }
    }

    private String removeSeparator(String str) {
        return str.isEmpty() ? "" : str.substring(0,
                str.length() - SEPARATOR.length());
    }

    public void insertAccount(AccountDto dto) {

    }
}

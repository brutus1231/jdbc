package pl.sda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountJdbcDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/zad1?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "scott";
    private static final String DB_PASS = "scott";

    Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}

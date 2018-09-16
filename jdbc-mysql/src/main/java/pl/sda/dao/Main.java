package pl.sda.dao;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        AccountJdbcDAO accountJdbcDAO = new AccountJdbcDAO();
        accountJdbcDAO.findAll();
    }

}

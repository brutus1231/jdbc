package pl.sda.dao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AccountDao accountDao = new AccountDao();
       /* accountDao.findAll();
        System.out.println();
        accountDao.findById();*/
        accountDao.findSize();
    }
}

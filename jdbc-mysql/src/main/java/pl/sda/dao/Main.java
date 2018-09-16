package pl.sda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        AccountJdbcDao accountJdbcDao = new AccountJdbcDao();

        try {
            accountJdbcDao.findAccountsCount();
            accountJdbcDao.findAll();
            accountJdbcDao.findById(1);
            accountJdbcDao.findByNumber("1");
            accountJdbcDao.findByCreationDate(Date.valueOf("1999-03-04"));
            accountJdbcDao.findAfterCreationDate(Date.valueOf("1999-03-04"));
        }catch (SQLException e){
            System.out.println(e);
        }
    }

}

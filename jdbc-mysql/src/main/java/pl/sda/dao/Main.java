package pl.sda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        AccountJdbcDao accountJdbcDao = new AccountJdbcDao();

        try {
            System.out.println("Ilość wpisów w tabeli account:");
            accountJdbcDao.findAccountsCount();
            System.out.println("Wszystkie wpisy:");
            accountJdbcDao.findAll();
            System.out.println("account_id = 1:");
            accountJdbcDao.findById(1);
            System.out.println("number = 1:");
            accountJdbcDao.findByNumber("1");
            System.out.println("creation_date = 2000-10-31:");
            accountJdbcDao.findByCreationDate("2000-10-31");
            System.out.println("creation_date after 2000-10-31:");
            accountJdbcDao.findAfterCreationDate("2000-10-31");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

}

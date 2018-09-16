package pl.sda.bo;

import pl.sda.dao.AccountDaoImpl;
import pl.sda.dto.AccountDto;

import java.util.Date;
import java.util.Scanner;

public class AccountBoImpl {

    private static final Scanner sc = new Scanner(System.in);
    private AccountDaoImpl dao = new AccountDaoImpl();

    public void createAccount() {
        AccountDto dto = new AccountDto();
        dto.setNumber(generateNumber());
        dto.setBalance(0.0);
        dto.setCreationDate(new Date());
        dao.insertAccount(dto);
    }

    private String generateNumber() {
        return null;
    }
}

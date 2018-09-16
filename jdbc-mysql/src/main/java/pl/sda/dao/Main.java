package pl.sda.dao;

import pl.sda.bo.AccountBoImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        generateMenu();
    }

    private static void generateMenu() throws IOException, InterruptedException {
        AccountBoImpl bo = new AccountBoImpl();
        Scanner scanner = new Scanner(System.in);
        String wybor;
        do {
            printMenu();
            wybor = scanner.next();
            switch (wybor) {
                case "1":
                    bo.createAccount();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
            }
        } while (wybor != "6");
    }

    private static void printMenu()  {
        System.out.println("1 - Dodanie nowego konta");
        System.out.println("2 - edycja instniejącego konta");
        System.out.println("6 - Wyjście z programu");
    }

}

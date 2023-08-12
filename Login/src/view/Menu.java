package view;

import entities.Account;
import service.Login;
import service.Register;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Login login = new Login();
    Register register = new Register();
    Account account = new Account();
    public void menu(){
        System.out.println("------MENU------");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng kí");
        System.out.println("0 - Thoát");
        System.out.println("nhập lựa chọn:");
    }
    public void selectMenu(Scanner scanner, ArrayList<Account> accounts) {
        boolean continueLoop = true;
        do {
            menu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        login.login(accounts, scanner);
                        break;
                    case 2:
                        account = register.account(accounts, scanner);
                        accounts.add(account);
                        break;
                    case 3:
                        System.out.println(accounts);
                        break;
                    case 0:
                        System.out.println("Tạm biệt! <3");
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        } while (continueLoop);
    }

}

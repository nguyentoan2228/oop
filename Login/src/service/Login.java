package service;

import entities.Account;
import view.MenuLogin;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    ServiceAccount serviceAccount = new ServiceAccount();
    ServiceLogin serviceLogin = new ServiceLogin();
    MenuLogin menuLogin = new MenuLogin();
    Register register = new Register();
    boolean continueLoop = true;

    public void login(ArrayList<Account> accounts, Scanner scanner) {
        do {
            String name = serviceAccount.getUsername(accounts, scanner);
            if (serviceAccount.isUniqueUsername(accounts, name)) {
                System.out.println("tài khoản chưa đăng ký");
                continueLoop = true;
            } else {
                for (Account i : accounts) {
                    if (i.getUserName().equalsIgnoreCase(name)) {
                        do {
                            String pass = serviceAccount.passWord(scanner);
                            if (i.getPassword().equals(pass)) {
                                menuLogin.menuLogin(scanner, accounts, i);
                                break;
                            } else {
                                System.out.println("mật khẩu sai vui lòng lựa chọn:");
                                System.out.println("1 - đăng nhập lại:");
                                System.out.println("2 - quên mật khẩu:");
                                int choice = Integer.parseInt(scanner.nextLine());
                                if (choice == 2) {
                                    do {
                                        serviceLogin.resetPassWord(i, scanner);
                                        break;
                                    } while (true);
                                }
                            }
                            break;
                        } while (true);
                    }
                }
                break;
            }
        } while (continueLoop);
    }
}

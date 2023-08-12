package view;

import entities.Account;
import service.ServiceAccount;
import service.ServiceLogin;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuLogin {
    ServiceLogin serviceLogin = new ServiceLogin();
    ServiceAccount serviceAccount = new ServiceAccount();
    public void menuLogin(Scanner scanner, ArrayList<Account> accounts, Account i){
        boolean continueLoop = true;
        do {
            System.out.println("đăng nhập thành công, Chào mừng "+i.getUserName()+", bạn có thể thực hiện các công việc sau:");
            System.out.println("1 - thay đổi username: ");
            System.out.println("2 - thay đổi email: ");
            System.out.println("3 - thay đổi mật khẩu: ");
            System.out.println("4 - đăng xuất");
            System.out.println("0 - thoát");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        serviceLogin.changeUser(accounts,i,scanner);
                        break;
                    case 2:
                        serviceLogin.changeEmail(accounts,i,scanner);
                        break;
                    case 3:
                        System.out.println("thay đổi mật khẩu!");
                        String pass1 = serviceAccount.passWord(scanner);
                        i.setPassword(pass1);
                        System.out.println("thay đổi mật khẩu thành công!");
                        break;
                    case 4:
                        continueLoop = false;
                        break;
                    case 0:
                        continueLoop = false;
                        break;
                }
            }catch (Exception e){
                System.out.println("nhập lại lựa chọn");
            }
        }while (continueLoop);
    }
}

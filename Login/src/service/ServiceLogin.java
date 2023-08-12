package service;

import entities.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceLogin {
    ServiceAccount serviceAccount = new ServiceAccount();
    public void resetPassWord(Account i, Scanner scanner){
        System.out.println("bạn vui lòng nhập email: ");
        String email = scanner.nextLine();
        if (i.getEmail().equals(email)){
            i.setPassword(serviceAccount.passWord(scanner));
            System.out.println("cập nhật mât khẩu mới thành công");
        }else {
            System.out.println("không tìm thấy emall");
        }

    }

    public void changeUser(ArrayList<Account> accounts, Account i , Scanner scanner){
        do {
            System.out.println("Đổi tên tài khoản");
            String name = serviceAccount.getUsername(accounts, scanner);
            if (serviceAccount.isUniqueUsername(accounts,name)){
                i.setUserName(name);
                System.out.println("Thay đổi tên tài khoản thành công");
                break;
            } else {
                System.out.println("Hệ thống đã có tên này. Vui lòng chọn tên khác.");
            }
        }while (true);
    }
    public void changeEmail(ArrayList<Account>accounts,Account i,Scanner scanner ){
        do {
            System.out.println("Đổi Email tài khoản");
            String email = serviceAccount.getEmail(accounts, scanner);
            if (serviceAccount.isUniqueEmail(accounts,email)){
                i.setEmail(email);
                System.out.println("Thay đổi email thành công");
                break;
            } else {
                System.out.println("Hệ thống đã có email này. Vui lòng chọn email khác.");
            }
        }while (true);
    }
}

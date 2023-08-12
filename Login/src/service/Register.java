package service;

import entities.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    ServiceAccount serviceAccount = new ServiceAccount();
    public Account account(ArrayList<Account>accounts,Scanner scanner){
        System.out.println("--------Đăng ký tài khoản--------");
        do {
            String username = serviceAccount.getUsername(accounts,scanner);
            if (serviceAccount.isUniqueUsername(accounts,username)){
                do {
                    String email = serviceAccount.getEmail(accounts,scanner);
                    if (serviceAccount.isUniqueEmail(accounts,email)){
                        String passWord = serviceAccount.passWord(scanner);
                        System.out.println("đăng ký tài khoản thành công <3");
                        return new Account(username,email,passWord);
                    } else {
                        System.out.println("email này đã có !");
                    }
                }while (true);
            } else {
                System.out.println("tên người dùng này đã có!");
            }
        }while (true);

    }
}

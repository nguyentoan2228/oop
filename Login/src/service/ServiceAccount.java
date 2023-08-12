package service;

import entities.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceAccount {
    public String getUsername(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("--------mời bạn nhập username:----- ");
        String userName = scanner.nextLine();
        return userName;
    }
    public String getEmail(ArrayList<Account> accounts, Scanner scanner) {
        do {
            System.out.println("--------mời bạn nhập email:------- ");
            String email = scanner.nextLine();
            if (isValidEmail(email)){
                return email;
            } else {
                System.out.println("vui lòng nhập đúng định dạng email!");
            }
        }while (true);
    }
    public String passWord(Scanner scanner){
        do {
            System.out.println("-------mời bạn nhập password:------ ");
            System.out.println("password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
            String passWord = scanner.nextLine();
            if (isValidPassword(passWord)) {
                return passWord;
            } else {
                System.out.println("vui lòng nhập đúng định dạng password!");
            }
        }while (true);
    }


    // password sử dụng regex
    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //PassWord sử dụng regex
    public boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[.,-_;])(?=\\S+$).{7,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    // điều kiện user chưa tồn tại
    public boolean isUniqueUsername(ArrayList<Account> accounts, String username) {
        for (Account account : accounts) {
            if (account.getUserName().equals(username)) {
                return false; // Tìm thấy tên người dùng trong danh sách
            }
        }
        return true; // Tên người dùng là duy nhất
    }
    public boolean isUniquePassWord(ArrayList<Account> accounts, String passWord) {
        for (Account account : accounts){
            if (account.getPassword().equals(passWord)) {
                return false;
            }
        }
        return true;
    }
    // điều kiện email chưa tồn tại
    public boolean isUniqueEmail(ArrayList<Account> accounts, String email) {
        for (Account account: accounts) {
            if (account.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}

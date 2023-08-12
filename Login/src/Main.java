import entities.Account;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ArrayList<Account> accounts = new ArrayList<>();

        menu.selectMenu(scanner,accounts);

    }
}
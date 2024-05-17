package com.iesam.digLibrary.features.menus;

import java.util.Scanner;
import java.util.Stack;

public class MenuSystem {
    Scanner scanner = new Scanner(System.in);

    public final Stack<Menu> menuStack;

    public MenuSystem() {
        menuStack = new Stack<>();
        // Initialize with the main menu
        menuStack.push(new MainMenu(this));
    }

    public  void run() {

        while (!menuStack.isEmpty()) {
            Menu currentMenu = menuStack.peek();
            currentMenu.display();
            int choice = scanner.nextInt();
            currentMenu.processChoice(choice);
        }
        scanner.close();
    }

    public void goToMenu(Menu menu) {
        menuStack.push(menu);
    }

    public void goBack() {
        if (menuStack.size() > 1) {
            menuStack.pop();
        } else {
            System.out.println("Exiting the program...");
            menuStack.clear();
        }
    }
}

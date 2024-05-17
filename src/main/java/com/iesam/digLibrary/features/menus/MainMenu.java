package com.iesam.digLibrary.features.menus;

public class MainMenu implements Menu {

    public final MenuSystem menuSystem;

    public MainMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    public void display() {

            ConsoleUtils.clearConsole();

            System.out.println("* Main menu * ");
            System.out.println("0. Exit");
            System.out.println("1. User management");
            System.out.println("2. Resources management");
            System.out.println("3. Loan management");
            System.out.println("4. Events management");
            System.out.print("Enter an option: ");

    }

    @Override
    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                menuSystem.goBack();
                break;
            case 1:
                menuSystem.goToMenu(new UserMenu(menuSystem));
                break;
            case 2:
                menuSystem.goToMenu(new ResourcesMenu(menuSystem));
                break;
            case 3:
                menuSystem.goToMenu(new LoansMenu(menuSystem));
                break;
            case 4:
                menuSystem.goToMenu(new EventMenu(menuSystem));
                break;

            default:
                System.out.println("Option not valid. Try again.");
                break;
        }

    }
}

package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.user.presentation.UserPresentation;

public class UserMenu implements Menu{
    public final MenuSystem menuSystem;
    public final UserPresentation presentation = new UserPresentation();

    public UserMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }
    @Override
    public void display() {
            ConsoleUtils.clearConsole();
            System.out.println("U. User management .U");
            System.out.println("0. Return to main menu");
            System.out.println("1. Register an user");
            System.out.println("2. Delete an user");
            System.out.println("3. Update an user");
            System.out.println("4. Get user information");
            System.out.println("5. Show all users list");
            System.out.print("Enter an option: ");

    }

    @Override
    public void processChoice(int choice) {

            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu");
                    menuSystem.goBack();
                    break;
                case 1: presentation.showUserForm();
                    System.out.println("Next operation");
                    break;
                case 2: presentation.deleteUserByDni();
                    System.out.println("Next operation");
                    break;
                case 3: presentation.updateUser();
                    System.out.println("Next operation");
                    return;
                case 4: presentation.getUser();
                    System.out.println("Next operation");
                    return;
                case 5: presentation.getAllUsers();
                    System.out.println("Next operation");
                    return;
                default:
                    System.out.println("Option not valid. Try again.");
                    break;

        }

    }
}

package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.resources.presentation.ResourcesPresentation;

public class ResourcesMenu implements Menu {
    public final MenuSystem menuSystem;

    public ResourcesMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    public void display() {
        ConsoleUtils.clearConsole();
        System.out.println("R. Resources management .R");
        System.out.println("0. Return to main menu");
        System.out.println("1. Register a resource");
        System.out.println("2. Delete a resource");
        System.out.println("3. Update a resource");
        System.out.println("4. Show all resources list");

        System.out.print("Enter an option: ");
    }

    @Override
    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Returning to the main menu...");
                menuSystem.goBack();
                break;
            case 1:
                ResourcesPresentation.showResourceForm();
                System.out.println("Next operation");
                return;
            case 2:
                ResourcesPresentation.deleteResourceById();
                System.out.println("Next operation");
                return;
            case 3:
                ResourcesPresentation.updateBook();
                System.out.println("Next operation");
                return;
            case 4:

                ResourcesPresentation.getAllRegisters();
                System.out.println("Next operation");
            default:
                System.out.println("Option not valid. Try again.");
                break;
        }
    }
}

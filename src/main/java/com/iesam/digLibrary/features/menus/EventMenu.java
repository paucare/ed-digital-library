package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.events.presentation.EventPresentation;
public class EventMenu implements Menu {
    public final MenuSystem menuSystem;

    public EventMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    public void display() {
        ConsoleUtils.clearConsole();
        System.out.println("E. Events management .E");
        System.out.println("0. Return to main menu");
        System.out.println("1. Register an event");
        System.out.println("2. Delete an event");
        System.out.println("3. Update an event");
        System.out.println("4. Show upcoming events");
        System.out.print("Enter an option:");
    }

    @Override
    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Returning to the main menu...");
                menuSystem.goBack();
                break;
            case 1:
                EventPresentation.createEvent();
                System.out.println("Next operation");
                return;
            case 2:
                EventPresentation.deleteEvent();
                System.out.println("Next operation");
                return;
            case 3:
                EventPresentation.updateEvent();
                System.out.println("Next operation");
                return;
            case 4:
                EventPresentation.getAllEvents();
                System.out.println("Next operation");
                return;
            default:
                System.out.println("Option not valid. Try again.");
                break;
        }
    }
}

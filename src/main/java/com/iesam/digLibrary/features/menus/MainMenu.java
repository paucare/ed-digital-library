package com.iesam.digLibrary.features.menus;

public class MainMenu extends Menu {

    public final MenuSystem menuSystem;

    public MainMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    void display() {

            ConsoleUtils.clearConsole();

            System.out.println("* Menu principal * ");
            System.out.println("0. Salir");
            System.out.println("1. Gestión de usuarios");
            System.out.println("2. Gestión de recursos");
            System.out.println("3. Gestión de prestamos");
            System.out.println("4. Gestión de eventos");
            System.out.print("Introduce una opción: ");

    }

    @Override
    void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Saliendo...");
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
                System.out.println("Opción no valida. Intentalo de nuevo");
                break;
        }

    }
}

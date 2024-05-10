package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.user.presentation.UserPresentation;

public class UserMenu extends Menu{
    public final MenuSystem menuSystem; // Reference to the MenuSystem instance

    public UserMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }
    @Override
    void display() {
            ConsoleUtils.clearConsole();
            System.out.println("U. Gestion de usuario .U");
            System.out.println("0. Volver al menu principal");
            System.out.println("1. Dar de alta a un usuario");
            System.out.println("2. Dar de baja un usuario");
            System.out.println("3. Actualizar un usuario");
            System.out.print("Introduce una opcion: ");

    }

    @Override
    void processChoice(int choice) {

            switch (choice) {
                case 0:
                    System.out.println("Volver al menu principal");
                    menuSystem.goBack();
                    break;
                case 1: UserPresentation.showUserForm();
                    System.out.println("Siguiente operación");
                    break;
                case 2: UserPresentation.deleteUserByDni();
                    System.out.println("Siguiente operación");
                    break;
                case 3: UserPresentation.updateUser();
                    System.out.println("Siguiente operación");
                    return;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
                    break;

        }

    }
}

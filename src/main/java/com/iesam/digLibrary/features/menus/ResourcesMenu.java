package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.resources.presentation.ResourcesPresentation;

public class ResourcesMenu extends Menu {
    public final MenuSystem menuSystem;

    public ResourcesMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    void display() {
        System.out.println("R. Gestion de recursos .R");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Dar de alta un recurso");
        System.out.println("2. Dar de baja un recurso");
        System.out.println("3. Actualizar un recurso");
        System.out.println("4. Mostrar lista de recursos");

        System.out.print("Introduce una opcion: ");
    }

    @Override
    void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Volver al menu principal");
                menuSystem.goBack();
                break;
            case 1:
                ResourcesPresentation.showResourceForm();
                System.out.println("Siguiente operación");
                return;
            case 2:
                ResourcesPresentation.deleteResourceById();
                System.out.println("Siguiente operación");
                return;
            case 3:
                ResourcesPresentation.updateBook();
                System.out.println("Siguiente operación");
                return;
            case 4:

                ResourcesPresentation.getAllRegisters();
                System.out.println("Siguiente operación");
            default:
                System.out.println("Opcion no valida. Intentalo de nuevo.");
                break;
        }
    }
}

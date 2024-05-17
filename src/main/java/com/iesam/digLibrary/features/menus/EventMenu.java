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
        System.out.println("E. Gestion de eventos .E");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Dar de alta un evento");
        System.out.println("2. Borrar un evento");
        System.out.println("3. Actualizar un evento");
        System.out.println("4. Mostrar próximos eventos");

    }

    @Override
    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Volver al menu principal");
                menuSystem.goBack();
                break;
            case 1:
                EventPresentation.createEvent();
                System.out.println("Siguiente operación");
                return;
            case 2:
                EventPresentation.deleteEvent();
                System.out.println("Siguiente operación");
                return;
            case 3:
                EventPresentation.updateEvent();
                System.out.println("Siguiente operación");
                return;
            case 4:
                EventPresentation.getAllEvents();
                System.out.println("Siguiente operación");
                return;
            default:
                System.out.println("Opcion no valida. Intentalo de nuevo.");
                break;
        }
    }
}

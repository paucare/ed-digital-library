package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.loans.presentation.LoanPresentation;

public class LoansMenu extends Menu{
    public final MenuSystem menuSystem;

    public LoansMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    void display() {
        ConsoleUtils.clearConsole();
        System.out.println("P. Gestion de prestamos .P");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Dar de alta un prestamo");
        System.out.println("2. Borrar un prestamo");
        System.out.println("3. Terminar un prestamo");
        System.out.println("4. Mostrar prestamos activos");
        System.out.println("5. Mostrar prestamos finalizados");
        System.out.println("6. Comprueba si el recurso se encuentra en un prestamo activo");

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
                LoanPresentation.showLoanForm();
                System.out.println("Siguiente operación");
                return;
            case 2:
                LoanPresentation.deleteLoan();
                System.out.println("Siguiente operación");
                return;
            case 3:
                LoanPresentation.returnResourceToEndLoan();
                System.out.println("Siguiente operación");
                return;
            case 4:
                LoanPresentation.getActiveLoans();
                System.out.println("Siguiente operación");
                return;
            case 5:
                LoanPresentation.getFinishedLoans();
                System.out.println("Siguiente operación");
                return;
            case 6:
                LoanPresentation.checkIfBookIsLoaned();
                System.out.println("Siguiente operacion");
                return;
            default:
                System.out.println("Opcion no valida. Intentalo de nuevo.");
                break;
        }
    }
}

package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.loans.presentation.LoanPresentation;

public class LoansMenu extends Menu{
    public final MenuSystem menuSystem;

    public LoansMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    void display() {
        System.out.println("P. Gestion de prestamos .P");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Dar de alta un prestamo");
        System.out.println("2. Borrar un prestamo");
        System.out.println("4. Mostrar prestamos activos");
        System.out.println("5. Mostrar prestamos finalizados");
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
                LoanPresentation.getActiveLoans();
                System.out.println("Siguiente operación");
                return;
            case 4:
                LoanPresentation.getFinishedLoans();
                System.out.println("Siguiente operación");
                return;
            default:
                System.out.println("Opcion no valida. Intentalo de nuevo.");
                break;
        }
    }
}

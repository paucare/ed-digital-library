package com.iesam;
import java.util.Scanner;

import com.iesam.digLibrary.features.loans.presentation.LoanPresentation;
import com.iesam.digLibrary.features.resources.books.presentation.BooksPresentation;
import com.iesam.digLibrary.features.user.presentation.UserPresentation;



public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        int option = -1;

        do {
            System.out.println("Menu");
            System.out.println("0. Salir");
            System.out.println("1. Dar de alta un usuario");
            System.out.println("2. Dar de baja un usuario");
            System.out.println("3. Actualizar un usuario");
            System.out.println("4. Dar de alta un recurso");
            System.out.println("5. Dar de baja un recurso");
            System.out.println("6. Consultar lista de recursos");
            System.out.println("7. Crear un prestamo");
            System.out.println("8. Borrar un prestamo");
            System.out.println("9. Listado de prestamos activos");
            System.out.println("10. Listado de prestamos finalizados");
            option = sc.nextInt();
            if (option > 0) {
                menuHandler(option);
            }

        } while (option != 0);
    }
    public static void menuHandler(int option){
        switch(option){
            case 1: UserPresentation.showUserForm();
            System.out.println("Siguiente operación");
            return;
            case 2: UserPresentation.deleteUserByDni();
            System.out.println("Siguiente operación");
            return;
            case 3: UserPresentation.updateUser();
            System.out.println("Siguiente operación");
            return;
            case 4: BooksPresentation.showResourceForm();
            System.out.println("Siguiente operación");
            return;
            case 5: BooksPresentation.deleteResourceById();
            System.out.println("Siguiente operación");
            return;
            case 6: BooksPresentation.getAllRegisters();
            System.out.println("Siguiente operación");
            return;
            case 7: LoanPresentation.showLoanForm();
            System.out.println("Siguiente operación");
            return;
            case 8: LoanPresentation.deleteLoan();
            System.out.println("Siguiente operación");
            return;
            case 9: LoanPresentation.getActiveLoans();
            System.out.println("Siguiente operación");
            return;
            case 10: LoanPresentation.getFinishedLoans();
            System.out.println("Siguiente operación");
            return;

            default:
                return;
        }
    }
}
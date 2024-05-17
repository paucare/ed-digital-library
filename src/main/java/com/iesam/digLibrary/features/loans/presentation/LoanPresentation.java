package com.iesam.digLibrary.features.loans.presentation;


import com.iesam.digLibrary.features.loans.data.LoanDataRepository;
import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.*;
import com.iesam.digLibrary.features.resources.books.data.BooksDataRepository;
import com.iesam.digLibrary.features.resources.books.data.local.BooksFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.books.domain.GetBookByIdUseCase;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.GetUserByIdUseCase;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.loans.domain.Loan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class LoanPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showLoanForm(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();

        System.out.println("Formulario de nuevo prestamo");
        /* System.out.println("Introduce el id del prestamo: ");
        int id = sc.nextInt();
        sc.nextLine();
        */
        System.out.println("Introduce el id del recurso: ");
        int resourceId = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el id del usuario: ");
        String userId = sc.nextLine();

        Date loanDate = currentDate;
        Date expectedDate = Loan.calculateExpectedDate(loanDate);

        System.out.println("Fecha de prestamo: " + formatter.format(loanDate));
        System.out.println("Fecha esperada de devolucion: " + formatter.format(expectedDate));


        GetUserByIdUseCase useCaseUser = new GetUserByIdUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        GetBookByIdUseCase useCaseResource = new GetBookByIdUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));

        Books selectedBook = useCaseResource.execute(resourceId);
        User selectedUser = useCaseUser.execute(userId);

        Loan loan = new Loan(selectedBook,selectedUser,loanDate,expectedDate,null);
        SaveLoanUseCase useCase = new SaveLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(loan);

        System.out.println("Se ha creado el prestamo con ID: " + loan.loanId);
    }
    public static void deleteLoan(){
    System.out.println("Introduce el ID del prestamo a borrar");
    int idLoan=sc.nextInt();
    sc.nextLine();
        DeleteLoanUseCase useCase = new DeleteLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(idLoan);
        System.out.println("Se ha borrado el prestamo con id: " + idLoan + " con exito");
    }
    public static void returnResourceToEndLoan(){
        System.out.println("Introduce el ID del prestamo cuyo recurso han devuelto: ");
        long unchangedId = sc.nextLong();
        sc.nextLine();
        EndLoanUseCase useCase = new EndLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(unchangedId);
        System.out.println("¡Gracias por devolver el recurso!");

    }
    public static void getActiveLoans(){
        System.out.println("A continuación se muestra una lista de los prestamos activos en nuestra biblioteca");
        GetActiveLoansUseCase useCase = new GetActiveLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> ListaActivos= useCase.execute();
        for(Loan element : ListaActivos){
            System.out.println("ID | Usuario | Recurso | Fecha de Prestamo | Fecha tope de devolución");
            System.out.println(element.loanId + " | " + element.user.name + " | " + element.resource.name + " | " + element.loanDate + " | " + element.expectedDate);
        }
    }
    public static void getFinishedLoans(){
        System.out.println("A continuación se muestra una lista de los prestamos finalizados en nuestra biblioteca");
        GetFinishedLoansUseCase useCase = new GetFinishedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> ListaFinalizados= useCase.execute();
        for(Loan element : ListaFinalizados){
            System.out.println("ID | Usuario | Recurso | Fecha de Prestamo | Fecha de devolucion");
            System.out.println(element.loanId + " | " + element.user.name + " | " + element.resource.name + " | " + element.loanDate + " | " + element.returnedDate);
        }
    }
    public static void checkIfBookIsLoaned() {

        System.out.println("Comprueba si el recurso esta prestado");
        System.out.println("Introduce el ID del libro a buscar");
        int searchId = sc.nextInt();
        CheckIfBookIsLoanedUseCase useCase = new CheckIfBookIsLoanedUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        boolean condition = useCase.execute(searchId);
        if (condition) {
            System.out.println("El libro se encuentra actualmente en un prestamo");
        } else {
            System.out.println("El libro se encuentra disponible.");
        }
    }

}

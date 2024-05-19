package com.iesam.digLibrary.features.loans.presentation;


import com.iesam.digLibrary.features.loans.data.LoanDataRepository;
import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.*;
import com.iesam.digLibrary.features.resources.books.data.BooksDataRepository;
import com.iesam.digLibrary.features.resources.books.data.local.BooksFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.books.domain.GetBookByIdUseCase;
import com.iesam.digLibrary.features.resources.music.data.MusicDataRepository;
import com.iesam.digLibrary.features.resources.music.data.local.MusicFileLocalDataSource;
import com.iesam.digLibrary.features.resources.music.domain.GetMusicByIdUseCase;
import com.iesam.digLibrary.features.resources.music.domain.Music;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.GetUserByIdUseCase;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.loans.domain.Loan;

import java.text.SimpleDateFormat;
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
        System.out.println("Enter the user ID: ");
        String userId = sc.nextLine();


        System.out.println("What kind of resource will you loan? 1.Book 2.CD");
        int option = sc.nextInt();
        sc.nextLine();

        GetUserByIdUseCase useCaseUser = new GetUserByIdUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User selectedUser = useCaseUser.execute(userId);
        switch (option) {
            case 1: handleBookLoan(selectedUser,currentDate,formatter);
                return;
            case 2: handleMusicLoan(selectedUser,currentDate,formatter);
                return;
            default:
                System.out.println("Enter a valid option,please.");
                break;
        }
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
    public static void checkIfResourceIsLoaned() {

        System.out.println("Comprueba si el recurso esta prestado");
        System.out.println("Introduce el ID del libro a buscar");
        int searchId = sc.nextInt();
        CheckIfResourceIsLoanedUseCase useCase = new CheckIfResourceIsLoanedUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        boolean condition = useCase.execute(searchId);
        if (condition) {
            System.out.println("El libro se encuentra actualmente en un prestamo");
        } else {
            System.out.println("El libro se encuentra disponible.");
        }
    }

    private static void handleBookLoan(User selectedUser, Date currentDate, SimpleDateFormat formatter) {
        System.out.println("Enter book id: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        GetBookByIdUseCase useCaseBook = new GetBookByIdUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
        Books selectedBook = useCaseBook.execute(bookId);

        Date expectedDate = Loan.calculateExpectedDate(currentDate);

        System.out.println("Loan date: " + formatter.format(currentDate));
        System.out.println("Expected return date: " + formatter.format(expectedDate));

        Loan loan = new Loan(selectedBook, selectedUser, currentDate, expectedDate, null);

        SaveLoanUseCase useCase = new SaveLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(loan);

        System.out.println("Loan with id: " + loan.loanId + " was saved");
    }
    private static void handleMusicLoan(User selectedUser, Date currentDate, SimpleDateFormat formatter) {
        System.out.println("Enter CD id: ");
        int musicId = sc.nextInt();
        sc.nextLine();

        GetMusicByIdUseCase useCaseMusic = new GetMusicByIdUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
        Music selectedMusic = useCaseMusic.execute(musicId);

        Date expectedDate = Loan.calculateExpectedDate(currentDate);

        System.out.println("Loan date: " + formatter.format(currentDate));
        System.out.println("Expected return date: " + formatter.format(expectedDate));

        Loan loan = new Loan(selectedMusic, selectedUser, currentDate, expectedDate, null);

        SaveLoanUseCase useCase = new SaveLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(loan);

        System.out.println("Loan with id: " + loan.loanId + " was saved");
    }

}

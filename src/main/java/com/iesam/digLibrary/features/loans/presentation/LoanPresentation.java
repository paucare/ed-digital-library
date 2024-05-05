package com.iesam.digLibrary.features.loans.presentation;


import com.iesam.digLibrary.features.loans.data.LoanDataRepository;
import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.*;
import com.iesam.digLibrary.features.resources.data.ResourcesDataRepository;
import com.iesam.digLibrary.features.resources.data.local.ResourcesFileLocalDataSource;
import com.iesam.digLibrary.features.resources.domain.GetResourceByIdUseCase;
import com.iesam.digLibrary.features.resources.domain.GetResourcesUseCase;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.DeleteUserUseCase;
import com.iesam.digLibrary.features.user.domain.GetUserByIdUseCase;
import com.iesam.digLibrary.features.user.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class LoanPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showLoanForm(){

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Formulario de nuevo prestamo");
        System.out.println("Introduce el id del prestamo: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el id del recurso: ");
        int resourceId = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el id del usuario: ");
        String userId = sc.nextLine();
        System.out.println("Introduce la fecha de prestamo: ");
        String stringLoanDate = sc.nextLine();
        Date loanDate = null;
        try {
            loanDate = formatter.parse(stringLoanDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce la fecha de devolucion: ");
        String stringReturnDate = sc.nextLine();
        Date returnDate = null;
        try {
            returnDate = formatter.parse(stringReturnDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GetUserByIdUseCase useCaseUser = new GetUserByIdUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        GetResourceByIdUseCase useCaseResource = new GetResourceByIdUseCase(new ResourcesDataRepository(new ResourcesFileLocalDataSource()));

        Resources selectedResource = useCaseResource.execute(resourceId);
        User selectedUser = useCaseUser.execute(userId);

        Loan loan = new Loan(id,selectedResource,selectedUser,loanDate,returnDate);
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
    public static void getActiveLoans(){
        System.out.println("A continuación se muestra una lista de los prestamos activos en nuestra biblioteca");
        GetActiveLoansUseCase useCase = new GetActiveLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> ListaActivos= useCase.execute();
        for(Loan element : ListaActivos){
            System.out.println("ID | Usuario | Recurso | Fecha de Prestamo | Fecha de devolucion");
            System.out.println(element.loanId + " | " + element.user + " | " + element.resource + " | " + element.loanDate + " | " + element.returnDate + " | ");
        }
    }
    public static void getFinishedLoans(){
        System.out.println("A continuación se muestra una lista de los prestamos finalizados en nuestra biblioteca");
        GetFinishedLoansUseCase useCase = new GetFinishedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> ListaFinalizados= useCase.execute();
        for(Loan element : ListaFinalizados){
            System.out.println("ID | Usuario | Recurso | Fecha de Prestamo | Fecha de devolucion");
            System.out.println(element.loanId + " | " + element.user + " | " + element.resource + " | " + element.loanDate + " | " + element.returnDate + " | ");
        }
    }
}

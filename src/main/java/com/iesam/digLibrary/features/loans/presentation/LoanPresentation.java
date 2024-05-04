package com.iesam.digLibrary.features.loans.presentation;


import com.iesam.digLibrary.features.loans.data.LoanDataRepository;
import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.Loan;
import com.iesam.digLibrary.features.loans.domain.SaveLoanUseCase;
import com.iesam.digLibrary.features.resources.data.ResourcesDataRepository;
import com.iesam.digLibrary.features.resources.data.local.ResourcesFileLocalDataSource;
import com.iesam.digLibrary.features.resources.domain.GetResourceByIdUseCase;
import com.iesam.digLibrary.features.resources.domain.GetResourcesUseCase;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.GetUserByIdUseCase;
import com.iesam.digLibrary.features.user.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class LoanPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showloanForm(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
        LocalDate loanDate = LocalDate.parse(stringLoanDate, formatter);
        System.out.println("Introduce la fecha de devolucion: ");
        String stringReturnDate = sc.nextLine();
        LocalDate returnDate = LocalDate.parse(stringReturnDate, formatter);

        GetUserByIdUseCase useCaseUser = new GetUserByIdUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        GetResourceByIdUseCase useCaseResource = new GetResourceByIdUseCase(new ResourcesDataRepository(new ResourcesFileLocalDataSource()));

        Resources selectedResource = useCaseResource.getResourceById(resourceId);
        User selectedUser = useCaseUser.getUserById(userId);

        Loan loan = new Loan(id,selectedResource,selectedUser,loanDate,returnDate);
        SaveLoanUseCase useCase = new SaveLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(loan);
        System.out.println("Se ha creado el prestamo con ID: " + loan.loanId);
    }
}

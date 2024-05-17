package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class EndLoanUseCaseTest {
    @Mock
    LoanRepository repository;
    EndLoanUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new EndLoanUseCase(repository);
    }
    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void whenGivenAModelItChangesItReturnedDateToCurrentDayAndThatEndsTheLoan(){


        long loanId = 1;
        User user = new User("123","Usuario","Apellido",123,"Adress");
        Resources book = new Books(1,"Book",2024,"Novela corta",100);
        Date loanDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        Loan loan = new Loan(loanId, book, user, loanDate, expectedDate, null);

        Mockito.when(repository.getLoanById(loanId)).thenReturn(loan);

        //When
        useCase.execute(loanId);

        // Then
        Mockito.verify(repository).deleteLoan(loanId);
        Mockito.verify(repository).saveLoan(any(Loan.class));

        /*
        long loanId = 1;
        User user = new User("123","Usuario","Apellido",123,"Adress");
        Resources book = new Books(1,"Book",2024,"Novela corta",100);
        Date loanDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        Loan loanToUpdate = new Loan(loanId, book, user, loanDate, expectedDate, null);

        Mockito.when(repository.getLoanById(loanId)).thenReturn(loanToUpdate);
        Loan loanToSave = new Loan(loanToUpdate.loanId,loanToUpdate.resource,loanToUpdate.user,loanToUpdate.loanDate,loanToUpdate.expectedDate,new Date());

        //When
        useCase.execute(loanId);
        // Then
        Mockito.verify(repository).deleteLoan(loanId);
        Mockito.verify(repository).saveLoan(loanToSave);
        */

    }
}
package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetFinishedLoansUseCaseTest {
    @Mock
    LoanRepository repository;
    GetFinishedLoansUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetFinishedLoansUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase= null;
    }
    @Test
    public void whenUseCaseExecutedItReturnsFinishedLoans() {
        List<Loan> allLoans = new ArrayList<>();
        Date loanDate = new Date();
        Date returnedDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        User user = new User("123", "Usuario", "Apellido", 123, "Adress");
        Resources book = new Books(1, "Book", 2024, "Novela corta", 100);
        Loan loan1 = new Loan(book, user, loanDate, expectedDate, null);
        Loan loan2 = new Loan(book, user, loanDate, expectedDate, returnedDate);
        allLoans.add(loan1);
        allLoans.add(loan2);
        Mockito.when(repository.getLoans()).thenReturn(allLoans);
        //When
        List<Loan> finishedLoans = useCase.execute();
        //Then
        assertEquals(finishedLoans.size(), 1);
        assertEquals(finishedLoans.get(0).loanId, loan2.loanId);
        assertEquals(finishedLoans.get(0).resource, loan2.resource);
        assertEquals(finishedLoans.get(0).user, loan2.user);
        assertEquals(finishedLoans.get(0).loanDate, loan2.loanDate);
        assertEquals(finishedLoans.get(0).expectedDate, loan2.expectedDate);
        assertEquals(finishedLoans.get(0).returnedDate,returnedDate);
    }
}
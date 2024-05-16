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
class GetLoansUseCaseTest {
    @Mock
    LoanRepository repository;
    GetLoansUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetLoansUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void whenUseCaseIsExecutedItReturnsAllModels(){
        //Given
        List<Loan> allLoans = new ArrayList<>();
        Date loanDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        User user = new User("123","Usuario","Apellido",123,"Adress");
        Resources book = new Books(1,"Book",2024,"Novela corta",100);
        Loan loan1 = new Loan(book,user,loanDate,expectedDate,null);
        allLoans.add(loan1);
        allLoans.add(loan1);
        Mockito.when(repository.getLoans()).thenReturn(allLoans);
        //When
        List<Loan> receivedLoans = useCase.execute();
        //Then
        assertEquals(receivedLoans.size(), allLoans.size());
        assertEquals(receivedLoans.get(0).loanId,loan1.loanId);
        assertEquals(receivedLoans.get(0).resource,loan1.resource);
        assertEquals(receivedLoans.get(0).user,loan1.user);
        assertEquals(receivedLoans.get(0).loanDate,loan1.loanDate);
        assertEquals(receivedLoans.get(0).expectedDate,loan1.expectedDate);
        assertEquals(receivedLoans.get(0).returnedDate,loan1.returnedDate);
        assertEquals(receivedLoans.get(1).loanId,loan1.loanId);
        assertEquals(receivedLoans.get(1).resource,loan1.resource);
        assertEquals(receivedLoans.get(1).user,loan1.user);
        assertEquals(receivedLoans.get(1).loanDate,loan1.loanDate);
        assertEquals(receivedLoans.get(1).expectedDate,loan1.expectedDate);
        assertEquals(receivedLoans.get(1).returnedDate,loan1.returnedDate);

    }
}
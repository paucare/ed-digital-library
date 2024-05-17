package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetLoanByIdTest {
    @Mock
    LoanRepository repository;
    GetLoanById useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetLoanById(repository);
    }
    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenGivenValidIdReturnModel(){
        //Given
        Date loanDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        long idLoan = System.currentTimeMillis();
        User user = new User("123","Usuario","Apellido",123,"Adress");
        Resources book = new Books(1,"Book",2024,"Novela corta",100);

        Loan loanExpected = new Loan(book,user,loanDate,expectedDate,null);

        Mockito.when(repository.getLoanById(idLoan)).thenReturn(loanExpected);

        //When
        Loan loanReceived = useCase.execute(idLoan);

        //Then
        Assertions.assertEquals(loanReceived.loanId,loanExpected.loanId);
        Assertions.assertEquals(loanReceived.resource,loanExpected.resource);
        Assertions.assertEquals(loanReceived.user,loanExpected.user);
        Assertions.assertEquals(loanReceived.loanDate,loanExpected.loanDate);
        Assertions.assertEquals(loanReceived.expectedDate,loanExpected.expectedDate);
        Assertions.assertEquals(loanReceived.returnedDate,loanExpected.returnedDate);

    }
}
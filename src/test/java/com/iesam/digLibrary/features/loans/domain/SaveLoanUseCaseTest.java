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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SaveLoanUseCaseTest {
    @Mock
    LoanRepository repository;
    SaveLoanUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new SaveLoanUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenGivenAModelSaveIt(){
        //Given
        Date loanDate = new Date();
        Date expectedDate = Loan.calculateExpectedDate(loanDate);
        User user = new User("123","Usuario","Apellido",123,"Adress");
        Resources book = new Books(1,"Book",2024,"Novela corta",100);

        Loan loanToSave = new Loan(book,user,loanDate,expectedDate,null);

        //When
        useCase.execute(loanToSave);

        //Then

        Mockito.verify(repository,Mockito.times(1)).saveLoan(loanToSave);


    }
}
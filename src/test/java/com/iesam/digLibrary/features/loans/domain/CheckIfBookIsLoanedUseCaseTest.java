package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.resources.books.domain.BooksRepository;
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

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckIfBookIsLoanedUseCaseTest {
    @Mock
    LoanRepository repository;
    CheckIfBookIsLoanedUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new CheckIfBookIsLoanedUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase=null;
    }
    @Test
    public void IfBookIsTakenReturnsFalse(){
        //Given
        Date currentDate = new Date();
        int bookId = 1;
        Books b1 = new Books(1,"Book",2024,"Novela corta",100);
        User u1 = new User("123","Usuario","Apellido",123,"Adress");
        Loan l1 = new Loan(b1,u1,currentDate,Loan.calculateExpectedDate(currentDate),null);
        boolean result = useCase.execute(1);

        Assertions.assertTrue(result);

    }
    @Test
    public void IfBookIsNotTakenReturnsTrue(){
        int bookId = 2;
        Books b1 = new Books(2,"Book",2024,"Novela corta",100);
        boolean result = useCase.execute(2);
        Assertions.assertFalse(result);

    }
}
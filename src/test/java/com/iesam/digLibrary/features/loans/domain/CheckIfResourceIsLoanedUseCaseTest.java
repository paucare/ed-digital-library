package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.books.domain.Books;
import com.iesam.digLibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CheckIfResourceIsLoanedUseCaseTest {
    @Mock
    LoanRepository repository;
    CheckIfResourceIsLoanedUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CheckIfResourceIsLoanedUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase =null;
    }
    @Test
    public void IfBookIsTakenReturnsTrue(){
        //Given
        Date currentDate = new Date();
        int bookId = 1;
        List<Loan> loans = new ArrayList<>();
        Books b1 = new Books(1,"Book",2024,"Novela corta",100);
        User u1 = new User("123","Usuario","Apellido",123,"Adress");
        Loan l1 = new Loan(b1,u1,currentDate,Loan.calculateExpectedDate(currentDate),null);
        loans.add(l1);

        Mockito.when(repository.getLoans()).thenReturn(loans);

        boolean result = useCase.execute(bookId);

        Assertions.assertTrue(result);

    }
    @Test
    public void IfBookIsNotTakenReturnsFalse(){
        int bookId = 2;
        Mockito.when(repository.getLoans()).thenReturn(new ArrayList<>());
        boolean result = useCase.execute(bookId);
        Assertions.assertFalse(result);

    }
}
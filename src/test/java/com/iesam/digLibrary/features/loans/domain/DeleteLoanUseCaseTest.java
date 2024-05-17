package com.iesam.digLibrary.features.loans.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeleteLoanUseCaseTest {
    @Mock
    LoanRepository repository;
    DeleteLoanUseCase useCase;
    @BeforeEach
    void SetUp(){
        useCase = new DeleteLoanUseCase(repository);
    }
    @AfterEach
    void tearDown(){
        useCase = null;
    }
    @Test
    public void whenGivenAnIdDeletesTheModel(){
        //Given
        long idLoanToDelete = System.currentTimeMillis();
        //When
        useCase.execute(idLoanToDelete);
        //Then
        Mockito.verify(repository,Mockito.times(1)).deleteLoan(idLoanToDelete);
    }

}
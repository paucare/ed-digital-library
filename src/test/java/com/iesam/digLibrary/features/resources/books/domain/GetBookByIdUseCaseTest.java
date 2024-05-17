package com.iesam.digLibrary.features.resources.books.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetBookByIdUseCaseTest {
    @Mock
    BooksRepository repository;
    GetBookByIdUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetBookByIdUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void whenUseCaseIsExecutedItReturnsAModel(){
        Books bookExpected = new Books(1,"Book",2024,"Synopsis",100);
        Mockito.when(repository.geBookById(1)).thenReturn(bookExpected);

        Books bookReceived = useCase.execute(1);

        Assertions.assertEquals(bookExpected.id,1);
        Assertions.assertEquals(bookExpected.name,"Book");
        Assertions.assertEquals(bookExpected.year,2024);
        Assertions.assertEquals(bookExpected.description,"Synopsis");
        Assertions.assertEquals(bookExpected.extension,100);
    }
}
package com.iesam.digLibrary.features.resources.books.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateBookUseCaseTest {
    @Mock
    BooksRepository repository;
    UpdateBookUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new UpdateBookUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void whenUseCaseIsExecutedItUpdatesTheModel(){
        Books bookToUpdate = new Books(1,"Book",2024,"Synopsis",100);

        useCase.execute(bookToUpdate);

        Mockito.verify(repository,Mockito.times(1)).updateBook(bookToUpdate);
    }
}
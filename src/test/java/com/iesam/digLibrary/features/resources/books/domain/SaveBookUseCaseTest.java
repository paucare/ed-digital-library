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
class SaveBookUseCaseTest {
    @Mock
    BooksRepository repository;
    SaveBookUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new SaveBookUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItSavesAModel(){
        Books bookToSave = new Books(1,"Book",2024,"Synopsis",100);
        useCase.execute(bookToSave);
        Mockito.verify(repository,Mockito.times(1)).saveBook(bookToSave);
    }
}
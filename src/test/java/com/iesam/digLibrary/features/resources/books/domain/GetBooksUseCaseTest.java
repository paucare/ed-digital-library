package com.iesam.digLibrary.features.resources.books.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetBooksUseCaseTest {
    @Mock
    BooksRepository repository;
    GetBooksUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetBooksUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItReturnsBooksList(){
        List<Books> allBooks = new ArrayList<>();
        Books b1 = new Books(1,"Book",2024,"Synopsis",100);
        allBooks.add(b1);
        allBooks.add(b1);
        Mockito.when(repository.getAllBooks()).thenReturn(allBooks);

        List <Books> booksReceived = useCase.execute();

        Assertions.assertEquals(booksReceived.size(),2);
        Assertions.assertEquals(booksReceived.get(0).id,1);
        Assertions.assertEquals(booksReceived.get(0).name,"Book");
        Assertions.assertEquals(booksReceived.get(0).year,2024);
        Assertions.assertEquals(booksReceived.get(0).description,"Synopsis");
        Assertions.assertEquals(booksReceived.get(0).extension,100);
        Assertions.assertEquals(booksReceived.get(1).id,1);
        Assertions.assertEquals(booksReceived.get(1).name,"Book");
        Assertions.assertEquals(booksReceived.get(1).year,2024);
        Assertions.assertEquals(booksReceived.get(1).description,"Synopsis");
        Assertions.assertEquals(booksReceived.get(1).extension,100);

    }
}
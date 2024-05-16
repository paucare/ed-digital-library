package com.iesam.digLibrary.features.events.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeleteEventUseCaseTest {
    @Mock
    EventRepository repository;
    DeleteEventUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new DeleteEventUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenIdIsInputtedItDeletesTheModel(){
        int eventIdInputted = 3134356;

        useCase.execute(eventIdInputted);

        Mockito.verify(repository,Mockito.times(1)).deleteEventById(eventIdInputted);
    }
}
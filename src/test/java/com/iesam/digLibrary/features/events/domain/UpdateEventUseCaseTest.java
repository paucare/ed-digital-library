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
    class UpdateEventUseCaseTest {
        @Mock
        EventRepository repository;
        UpdateEventUseCase useCase;
        @BeforeEach
        void setUp() {
            useCase = new UpdateEventUseCase(repository);
        }

        @AfterEach
        void tearDown() {
            useCase = null;
        }
        @Test
        public void whenIdIsInputtedItDeletesTheModel(){

            Event eventToUpdate = new Event(1,"e1","hoy",50);

            useCase.execute(eventToUpdate);

            Mockito.verify(repository,Mockito.times(1)).updateEvent(eventToUpdate);
        }
    }
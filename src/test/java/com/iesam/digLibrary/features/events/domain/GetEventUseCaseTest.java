package com.iesam.digLibrary.features.events.domain;

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
class GetEventUseCaseTest {

    @Mock
    EventRepository repository;
    GetEventUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetEventUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void givenAValidEventIdThenReturnsAnEvent() {
        Event eventExpected = new Event(123, "Cine de verano", "12/06/2024", 30);
        Mockito.when(repository.getEventById(123)).thenReturn(eventExpected);

        Event eventReceived = useCase.execute(123);

        Assertions.assertEquals(eventReceived.eventId, eventExpected.eventId);
        Assertions.assertEquals(eventReceived.name, eventExpected.name);
        Assertions.assertEquals(eventReceived.date, eventExpected.date);
        Assertions.assertEquals(eventReceived.capacity, eventExpected.capacity);
    }
    @Test
    public void givenNotValidIdThenNullIsReturned(){
        int eventIdNotValid = 3134356;

        Event eventReceived = useCase.execute(eventIdNotValid);

        Assertions.assertNull(eventReceived);
    }
}
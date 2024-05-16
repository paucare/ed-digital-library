package com.iesam.digLibrary.features.events.domain;

import org.junit.jupiter.api.AfterEach;
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
class GetEventsUseCaseTest {
    @Mock
    EventRepository repository;
    GetEventsUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetEventsUseCase(repository);
    }
    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void returnsAllUsers(){
        //Given
        List<Event> eventsExpected = new ArrayList<>();
        Event e1 = new Event(1,"e1","hoy",50);
        //Event e2 = new Event(2,"e2","hoy",60);
        eventsExpected.add(e1);
        //eventsExpected.add(e2);
        eventsExpected.add(e1);
        Mockito.when(repository.getAllEvents()).thenReturn(eventsExpected);
        //When
        List<Event> events = useCase.execute();
        //Then
        assertEquals(eventsExpected.size(), events.size());
        assertEquals(eventsExpected.get(0).eventId,e1.eventId);
        assertEquals(eventsExpected.get(0).name,"e1");
        assertEquals(eventsExpected.get(0).date,"hoy");
        assertEquals(eventsExpected.get(0).capacity,50);
        assertEquals(eventsExpected.get(1).eventId,1);
        assertEquals(eventsExpected.get(1).name,"e1");
        assertEquals(eventsExpected.get(1).date,"hoy");
        assertEquals(eventsExpected.get(1).capacity,50);

        /*
        assertEquals(eventsExpected.get(1).eventId,2);
        assertEquals(eventsExpected.get(1).name,"e2");
        assertEquals(eventsExpected.get(1).date,"hoy");
        assertEquals(eventsExpected.get(1).capacity,60);
         */

    }
}
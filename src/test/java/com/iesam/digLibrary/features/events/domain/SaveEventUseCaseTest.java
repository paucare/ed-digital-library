package com.iesam.digLibrary.features.events.domain;

import com.iesam.digLibrary.features.user.domain.SaveUserUseCase;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SaveEventUseCaseTest {

    @Mock
    EventRepository repository;
    SaveEventUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new SaveEventUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenGivenAModelSaveIt(){
        //Given
        Event eventToSave = new Event(1,"e1","hoy",50);
        //When
        useCase.execute(eventToSave);
        //Then
        Mockito.verify(repository,Mockito.times(1)).saveEvent(eventToSave);
    }
}
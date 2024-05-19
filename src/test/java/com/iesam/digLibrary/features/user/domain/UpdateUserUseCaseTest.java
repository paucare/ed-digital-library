package com.iesam.digLibrary.features.user.domain;

import com.iesam.digLibrary.features.exceptions.NotValidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseTest {

    @Mock
    UserRepository repository;
    UpdateUserUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new UpdateUserUseCase(repository);
    }
    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenGivenAModelUpdateIt(){
        //Given
        User user = new User("8001","User","Surname",600800900,"Calle");
        Mockito.when(repository.getUserById(user.dni)).thenReturn(user);
        //When
        useCase.execute(user);
        //Then
        Mockito.verify(repository,Mockito.times(1)).updateUser(user);

    }

    @Test
    public void notExistingUserWithSaidIdUpdatesNothing(){
        //Given
        User user = new User("8001","User","Surname",600800900,"Calle");
        Mockito.when(repository.getUserById(user.dni)).thenReturn(null);
        //When
        NotValidInputException e = assertThrows(NotValidInputException.class, () -> useCase.execute(user));
        assertEquals("The user does not exist", e.getMessage());
        //Then
        Mockito.verify(repository,Mockito.times(0)).updateUser(user);

    }
}
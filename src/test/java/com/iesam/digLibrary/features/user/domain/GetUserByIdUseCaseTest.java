package com.iesam.digLibrary.features.user.domain;

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
class GetUserByIdUseCaseTest {

    @Mock
    UserRepository repository;

    GetUserByIdUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetUserByIdUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void givenAValidUserIdThenReturnsAUser(){
        //Given
        User userExpected = new User("8001","Usuario","Apellido",600800900,"Calle");
        Mockito.when(repository.getUserById("8001")).thenReturn(userExpected);
        //When
        User userReceived = useCase.execute("8001");
        //Then
        Assertions.assertEquals(userReceived.dni,"8001");
        Assertions.assertEquals(userReceived.name,"Usuario");
        Assertions.assertEquals(userReceived.surname,"Apellido");
        Assertions.assertEquals(userReceived.phoneNumber,600800900);
        Assertions.assertEquals(userReceived.address,"Calle");
    }
    @Test
    public void givenNotValidIdThenNullIsReturned(){
        //Given
        String notValidId="100000000";
        Mockito.when(repository.getUserById(notValidId)).thenReturn(null);
        //When
        User userReceived = useCase.execute(notValidId);
        //Then
        Assertions.assertNull(userReceived);
    }
}
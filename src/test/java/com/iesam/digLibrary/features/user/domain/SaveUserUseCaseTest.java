package com.iesam.digLibrary.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SaveUserUseCaseTest {

    @Mock
    UserRepository repository;
    SaveUserUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new SaveUserUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenGivenAModelSaveIt(){
        //Given
        User user = new User("8001","User","Surname",600800900,"Address");
        Mockito.when(repository.getUserById(user.dni)).thenReturn(null);
        //When
        useCase.execute(user);
        //Then
        Mockito.verify(repository,Mockito.times(1)).saveUser(user);
    }
    @Test
    public void alreadyExistingUserWithSaidIDReturnsNothing() {

        //Given
        User existingUser = new User("existingId", "Existing", "User", 123456789, "Address");
        Mockito.when(repository.getUserById(existingUser.dni)).thenReturn(existingUser);

        //When
        //useCase.execute(existingUser);
        useCase.execute(existingUser);

        //Then
        Mockito.verify(repository, Mockito.times(0)).saveUser(existingUser);

    }
}
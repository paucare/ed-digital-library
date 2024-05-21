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
class DeleteUserUseCaseTest {
    @Mock
    UserRepository repository;
    DeleteUserUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new DeleteUserUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }

    @Test
    public void whenIdIsInputtedItDeletesTheModel(){
        //Given
        User userToDelete = new User("existingId", "Existing", "User", 123456789, "Address");
        Mockito.when(repository.getUserById(userToDelete.dni)).thenReturn(userToDelete);
        //When
        useCase.execute(userToDelete.dni);
        //Then
        Mockito.verify(repository,Mockito.times(1)).deleteUser(userToDelete.dni);
    }

    @Test
    public void notExistingUserWithSaidIdDeletesNothing(){
        //Given
        User userToDelete = new User("existingId", "Existing", "User", 123456789, "Address");
        Mockito.when(repository.getUserById(userToDelete.dni)).thenReturn(null);
        //When
       useCase.execute(userToDelete.dni);
        //Then
        Mockito.verify(repository,Mockito.times(0)).deleteUser(userToDelete.dni);

    }

}
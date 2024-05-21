package com.iesam.digLibrary.features.user.domain;

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
class GetUsersUseCaseTest {
    @Mock
    UserRepository repository;
    GetUsersUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new GetUsersUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItReturnsAnUserList(){
        List<User> allUsers = new ArrayList<>();
        User u1 = new User("ABC123","Name","Surname",123,"Address");
        allUsers.add(u1);
        allUsers.add(u1);
        Mockito.when(repository.getAllUsers()).thenReturn(allUsers);

        List<User> usersReceived = useCase.execute();

        Assertions.assertEquals(usersReceived.size(),2);
        Assertions.assertEquals(usersReceived.get(0).dni,"ABC123");
        Assertions.assertEquals(usersReceived.get(0).name,"Name");
        Assertions.assertEquals(usersReceived.get(0).surname,"Surname");
        Assertions.assertEquals(usersReceived.get(0).phoneNumber,123);
        Assertions.assertEquals(usersReceived.get(0).address,"Address");
        Assertions.assertEquals(usersReceived.get(1).dni,"ABC123");
        Assertions.assertEquals(usersReceived.get(1).name,"Name");
        Assertions.assertEquals(usersReceived.get(1).surname,"Surname");
        Assertions.assertEquals(usersReceived.get(1).phoneNumber,123);
        Assertions.assertEquals(usersReceived.get(1).address,"Address");
    }

}
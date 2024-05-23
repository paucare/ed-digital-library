package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
class UserPresentationTest {

    @Mock
    UseCasesUserFactory factory;
    @Mock
    UserRepository repository;
    @InjectMocks
    UserPresentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new UserPresentation(factory);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        presentation = null;
    }

    @Test
    public void testShowUserForm_CallsFactoryCorrectly() {

        SaveUserUseCase useCase = new SaveUserUseCase(repository);

        Mockito.when(factory.buildSaveUser()).thenReturn(useCase);

        String simulatedInput = "123\nBenito Antonio\nMartinez Ocasio\n123456789\nAdress\n";

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        UserPresentation.sc = new Scanner(System.in);

        presentation.showUserForm();

        Mockito.verify(factory, Mockito.times(1)).buildSaveUser();
    }
    @Test
    public void testDeleteUser_CallsFactoryCorrectly(){

        DeleteUserUseCase useCase = new DeleteUserUseCase(repository);
        Mockito.when(factory.buildDeleteUser()).thenReturn(useCase);
        String simulatedInput = "123";

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        UserPresentation.sc = new Scanner(System.in);

        presentation.deleteUserByDni();

        Mockito.verify(factory, Mockito.times(1)).buildDeleteUser();

    }
    @Test
    public void testUpdateForm_CallsFactoryCorrectly() {

        UpdateUserUseCase useCase = new UpdateUserUseCase(repository);

        Mockito.when(factory.buildUpdateUser()).thenReturn(useCase);

        String simulatedInput = "123\nBenito Antonio\nMartinez Ocasio\n123456789\nAdress\n";

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        UserPresentation.sc = new Scanner(System.in);

        presentation.updateUser();

        Mockito.verify(factory, Mockito.times(1)).buildUpdateUser();
    }
    @Test
    public void testGetAUser_CallsFactoryCorrectly(){

        GetUserByIdUseCase useCase = new GetUserByIdUseCase(repository);

        Mockito.when(factory.buildGetUserById()).thenReturn(useCase);
        String simulatedInput = "8001";

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        UserPresentation.sc = new Scanner(System.in);

        presentation.getUser();

        Mockito.verify(factory, Mockito.times(1)).buildGetUserById();

    }
    @Test
    public void testGetAllUser_CallsFactoryCorrectly(){

        GetUsersUseCase useCase = new GetUsersUseCase(repository);

        Mockito.when(factory.buildGetAllUsers()).thenReturn(useCase);

        presentation.getAllUsers();

        Mockito.verify(factory, Mockito.times(1)).buildGetAllUsers();

    }

}
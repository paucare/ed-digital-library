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
        presentation.sc = new Scanner(System.in);

        //Capturamos la salida
        /*
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
         */

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
        presentation.sc = new Scanner(System.in);

        //Capturamos la salida
        /*
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
         */

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
        presentation.sc = new Scanner(System.in);

        //Capturamos la salida
        /*
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
         */

        presentation.updateUser();

        Mockito.verify(factory, Mockito.times(1)).buildUpdateUser();
    }
    @Test
    public void testGetAUser_CallsFactoryCorrectly(){

        GetUserByIdUseCase useCase = new GetUserByIdUseCase(repository);

        Mockito.when(factory.buildGetUserById()).thenReturn(useCase);
        String simulatedInput = "8001";

        //Comprobamos que el usuario que pedimos es el que es devuelto
        /*
        User user = new User("8001","User","Surname",600800900,"Address");
        Mockito.when(repository.getUserById("8001")).thenReturn(user);

        User userRetrieved = useCase.execute("8001");
        Assertions.assertEquals(userRetrieved.dni,"8001");
        Assertions.assertEquals(userRetrieved.name,"User");
        Assertions.assertEquals(userRetrieved.surname,"Surname");
        Assertions.assertEquals(userRetrieved.phoneNumber,600800900);
        Assertions.assertEquals(userRetrieved.address,"Address");

         */

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        presentation.sc = new Scanner(System.in);

        //Capturamos la salida
        /*
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
         */

        presentation.getUser();

        Mockito.verify(factory, Mockito.times(1)).buildGetUserById();

    }
    @Test
    public void testGetAllUser_CallsFactoryCorrectly(){
        /*
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

         */

        GetUsersUseCase useCase = new GetUsersUseCase(repository);

        Mockito.when(factory.buildGetAllUsers()).thenReturn(useCase);

        presentation.getAllUsers();

        Mockito.verify(factory, Mockito.times(1)).buildGetAllUsers();

    }

}
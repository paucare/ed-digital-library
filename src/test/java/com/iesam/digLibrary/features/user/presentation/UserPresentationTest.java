package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.domain.SaveUserUseCase;
import com.iesam.digLibrary.features.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
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
    UserFactory factory;
    @Mock
    UserRepository repository;
    @InjectMocks
    UserPresentation presentation;

    SaveUserUseCase useCase;


    @BeforeEach
    void setUp() {
        presentation = new UserPresentation(factory);
        useCase = new SaveUserUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        presentation = null;
        useCase = null;
    }

    @Test
    public void testShowUserForm_CallsFactoryCorrectly() {

        Mockito.when(factory.buildSaveUser()).thenReturn(useCase);

        String simulatedInput = "123\nBenito Antonio\nMartinez Ocasio\n123456789\nAdress\n";

        //Capturamos la entrada
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);
        presentation.sc = new Scanner(System.in);

        //Capturamos la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        presentation.showUserForm();

        Mockito.verify(factory, Mockito.times(1)).buildSaveUser();
    }
}
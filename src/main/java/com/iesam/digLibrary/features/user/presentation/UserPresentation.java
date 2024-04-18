package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.data.*;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.*;
import java.util.Scanner;

public class UserPresentation {


    public static void showUserForm(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Formulario de nuevo usuario");
        System.out.println("Introduce el dni: ");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();
        System.out.println("Introduce el apellido: ");
        String surname = sc.nextLine();
        System.out.println("Introduce el telefono: ");
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce la dirección: ");
        String address = sc.nextLine();

        User user = new User(dni,name,surname,phoneNumber,address);
        SaveUserUseCase useCase = new SaveUserUseCase(new UserDataRepository(UserFileLocalDataSource.getInstance()));
        useCase.execute(user);
        System.out.println("Se ha guardado el usuario: " + user.name);
    }

}

package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.data.*;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.*;
import java.util.Scanner;

public class UserPresentation {
  
    static Scanner sc = new Scanner(System.in);

    public static void showUserForm(){

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
        SaveUserUseCase useCase = new SaveUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        useCase.execute(user);
        System.out.println("Se ha guardado el usuario: " + user.name);
    }

    public static void deleteUserByDni(){
        System.out.println("Introduce el dni del usuario a borrar: ");
        String dni = sc.nextLine();
        DeleteUserUseCase useCase = new DeleteUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        useCase.execute(dni);
        System.out.println("Se ha borrado el usuario con dni " + dni + " con exito");
    }

    public static void updateUser(){
            System.out.println("Formulario para editar datos de usuario");
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
            UpdateUserUseCase useCase = new UpdateUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
            useCase.execute(user);
            System.out.println("");

    }

}

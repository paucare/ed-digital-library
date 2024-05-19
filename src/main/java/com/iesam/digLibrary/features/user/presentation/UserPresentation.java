package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.data.*;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.*;
import java.util.Scanner;

public class UserPresentation {
  
    static Scanner sc = new Scanner(System.in);

    public static void showUserForm(){

        System.out.println("New user form");
        System.out.println("Enter the ID: ");
        String dni = sc.nextLine();
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Enter the surname: ");
        String surname = sc.nextLine();
        System.out.println("Enter the phone number: ");
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the address: ");
        String address = sc.nextLine();

        User user = new User(dni,name,surname,phoneNumber,address);
        SaveUserUseCase useCase = new SaveUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));

            useCase.execute(user);
            System.out.println("The user: " + user.name + " was saved");

    }

    public static void deleteUserByDni(){
        System.out.println("Enter the users' ID to delete: ");
        String dni = sc.nextLine();
        DeleteUserUseCase useCase = new DeleteUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));

            useCase.execute(dni);
            System.out.println("The user with ID: " + dni + " was deleted successfully");
    }

    public static void updateUser() {

        System.out.println("Enter the user's ID to delete");
        String unchangedId = sc.nextLine();

        System.out.println("Edit user data form");
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Enter the surname: ");
        String surname = sc.nextLine();
        System.out.println("Enter the phone number: ");
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the address: ");
        String address = sc.nextLine();
        User updatedUser = new User(unchangedId, name, surname, phoneNumber, address);
        UpdateUserUseCase useCase = new UpdateUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        useCase.execute(updatedUser);

    }
}

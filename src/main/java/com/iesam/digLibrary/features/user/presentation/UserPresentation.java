package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.user.domain.*;

import java.util.List;
import java.util.Scanner;

public class UserPresentation {
  
    static Scanner sc = new Scanner(System.in);
    static UseCasesUserFactory factory = new UseCasesUserFactory();

    public UserPresentation(UseCasesUserFactory factory){
        UserPresentation.factory =factory;
    }

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
        SaveUserUseCase useCase = factory.buildSaveUser();
        useCase.execute(user);
        System.out.println("The user: " + user.name + " was saved");

    }

    public static void deleteUserByDni(){
        System.out.println("Enter the users' ID to delete: ");
        String dni = sc.nextLine();
        DeleteUserUseCase useCase = factory.buildDeleteUser();
        useCase.execute(dni);
        System.out.println("The user with ID: " + dni + " was deleted successfully");
    }

    public static void updateUser() {

        System.out.println("Enter the user's ID to update");
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
        UpdateUserUseCase useCase = factory.buildUpdateUser();
        useCase.execute(updatedUser);
        System.out.println("The user with ID: " + unchangedId + " was updated successfully");
    }
        public static void getUser(){
            System.out.println("Enter the user's ID to search: ");
            String id = sc.nextLine();
            GetUserByIdUseCase useCase = factory.buildGetUserById();
            User user = useCase.execute(id);
            if(user!=null){
                System.out.println("User info: ");
                System.out.println("ID: " + user.dni + "| Name: " + user.name + "| Surname: " + user.surname);
            } else {
                System.out.println("User does not exist");
            }
        }

    public static void getAllUsers(){
        GetUsersUseCase useCase = factory.buildGetAllUsers();
        List<User> userList = useCase.execute();
        if(!userList.isEmpty()) {
            System.out.println("Next there is a list with all the users stored: ");
            for (User element : userList) {
                System.out.println("ID: " + element.dni + "| Name: " + element.name + "| Surname: " + element.surname);
            }
        } else {
            System.out.println("Currently we have no users");
        }
    }

}

package com.iesam.digLibrary.features.user.presentation;

import com.iesam.digLibrary.features.loans.presentation.LoanPresentation;
import com.iesam.digLibrary.features.user.data.*;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.*;

import java.util.List;
import java.util.Scanner;

public class UserPresentation {
  
    static Scanner sc = new Scanner(System.in);
    final UserFactory factory = new UserFactory();

    public UserPresentation() {
    }

    public void showUserForm(){

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
        //SaveUserUseCase useCase = new SaveUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        SaveUserUseCase useCase = factory.buildSaveUser();
        useCase.execute(user);
        System.out.println("The user: " + user.name + " was saved");

    }

    public void deleteUserByDni(){
        System.out.println("Enter the users' ID to delete: ");
        String dni = sc.nextLine();
        //DeleteUserUseCase useCase = new DeleteUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        DeleteUserUseCase useCase = factory.buildDeleteUser();
        useCase.execute(dni);
        System.out.println("The user with ID: " + dni + " was deleted successfully");
    }

    public void updateUser() {

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
        //UpdateUserUseCase useCase = new UpdateUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        UpdateUserUseCase useCase = factory.buildUpdateUser();
        useCase.execute(updatedUser);
        System.out.println("The user with ID: " + unchangedId + " was updated successfully");
    }
        public void getUser(){
            System.out.println("Enter the user's ID to search: ");
            String id = sc.nextLine();
            //GetUserByIdUseCase useCase =  new GetUserByIdUseCase(new UserDataRepository(new UserFileLocalDataSource()));
            GetUserByIdUseCase useCase = factory.buildGetUserById();
            User user = useCase.execute(id);
            if(user!=null){
                System.out.println("User info: ");
                System.out.println("ID: " + user.dni + "Name: " + user.name + " Surname: " + user.surname);
            } else {
                System.out.println("User does not exist");
            }
        }

    public void getAllUsers(){
        //GetUsersUseCase useCase =  new GetUsersUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        GetUsersUseCase useCase = factory.buildGetAllUsers();
        List<User> userList = useCase.execute();
        if(!userList.isEmpty()) {
            System.out.println("Next there is a list with all the users stored: ");
            for (User element : userList) {
                System.out.println("ID: " + element.dni + " Name: " + element.name + " Surname: " + element.surname);
            }
        } else {
            System.out.println("Currently we have no users");
        }
    }

}

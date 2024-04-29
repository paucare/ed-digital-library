package com.iesam.digLibrary.features.resources.presentation;
import java.awt.print.Book;
import java.util.Scanner;
import com.iesam.digLibrary.features.resources.data.*;
import com.iesam.digLibrary.features.resources.domain.*;

public class ResourcesPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showResourceForm(){

        System.out.println("Ingrese los datos del recurso digital");
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();
        System.out.println("Introduce el apellido: ");
        String surname = sc.nextLine();
        System.out.println("Introduce el telefono: ");
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce la dirección: ");
        String address = sc.nextLine();

        Resources resource = new Books(id,name,surname,phoneNumber,address);
        SaveResourceUseCase useCase = new SaveResourceUseCase(new ResourcesDataRepository(new ResourceFileLocalDataSource()));
        useCase.execute(user);
        System.out.println("Se ha guardado el usuario: " + user.name);
    }
}

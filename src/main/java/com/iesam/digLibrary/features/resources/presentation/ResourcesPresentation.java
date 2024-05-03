package com.iesam.digLibrary.features.resources.presentation;
import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;
import com.iesam.digLibrary.features.resources.data.*;
import com.iesam.digLibrary.features.resources.data.local.ResourcesFileLocalDataSource;
import com.iesam.digLibrary.features.resources.domain.*;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.DeleteUserUseCase;

public class ResourcesPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showResourceForm(){

        System.out.println("Ingrese los datos del recurso digital");
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();
        System.out.println("Introduce el año: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce una descripción: ");
        String description = sc.nextLine();
        System.out.println("Introduce la extension: ");
        int extension = sc.nextInt();
        sc.nextLine();

        Resources resource = new Books(id,name,year,description,extension);
        SaveResourceUseCase useCase = new SaveResourceUseCase(new ResourcesDataRepository(new ResourcesFileLocalDataSource()));
        useCase.execute(resource);
        System.out.println("Se ha guardado el libro: " + resource.name);
    }
    public static void deleteResourceById(){
        System.out.println("Introduce el id del libro a borrar: ");
        int id = sc.nextInt();
        DeleteResourceUseCase useCase = new DeleteResourceUseCase(new ResourcesDataRepository(new ResourcesFileLocalDataSource()));
        useCase.execute(id);
        System.out.println("Se ha borrado el recurso con id " + id + " con exito");
    }

    public static void getAllRegisters(){
        System.out.println("A continuación se muestra una lista de los recursos existentes en nuestra biblioteca");
        GetResourcesUseCase useCase = new GetResourcesUseCase(new ResourcesDataRepository(new ResourcesFileLocalDataSource()));
        List<Resources> ListaRecursos= useCase.execute();
        for(Resources element : ListaRecursos){
            System.out.println(element.name + " ("  + element.year + ") ");
        }
    }

}

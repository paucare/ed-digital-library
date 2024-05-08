package com.iesam.digLibrary.features.resources.presentation;
import java.util.List;
import java.util.Scanner;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.resources.books.data.local.BooksFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.*;
import com.iesam.digLibrary.features.resources.books.data.*;


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

        Books resource = new Books(id,name,year,description,extension);
        SaveBookUseCase useCase = new SaveBookUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
        useCase.execute(resource);
        System.out.println("Se ha guardado el libro: " + resource.name);
    }
    public static void deleteResourceById(){
        System.out.println("Introduce el id del libro a borrar: ");
        int id = sc.nextInt();
        DeleteBookUseCase useCase = new DeleteBookUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
        useCase.execute(id);
        System.out.println("Se ha borrado el recurso con id " + id + " con exito");
    }

    public static void getAllRegisters(){
        System.out.println("A continuación se muestra una lista de los recursos existentes en nuestra biblioteca");
        GetBooksUseCase useCase = new GetBooksUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
        List<Books> ListaRecursos= useCase.execute();
        for(Resources element : ListaRecursos){
            System.out.println(element.name + " ("  + element.year + ") ");
        }
    }

}

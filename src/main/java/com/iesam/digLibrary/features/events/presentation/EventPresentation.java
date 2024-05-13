package com.iesam.digLibrary.features.events.presentation;

import com.iesam.digLibrary.features.events.data.EventDataRepository;
import com.iesam.digLibrary.features.events.data.local.EventFileLocalDataSource;
import com.iesam.digLibrary.features.events.data.local.EventMemLocalDataSource;
import com.iesam.digLibrary.features.events.domain.*;

import java.util.List;
import java.util.Scanner;

public class EventPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void createEvent(){
        System.out.println("Formulario de nuevo evento");
        System.out.println("ID del evento");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nombre del evento");
        String name = sc.nextLine();
        System.out.println("Fecha del evento");
        String date = sc.nextLine();
        System.out.println("Plazas del evento");
        int seats = sc.nextInt();
        sc.nextLine();

        Event event = new Event(id,name,date,seats);
        SaveEventUseCase useCase = new SaveEventUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        useCase.execute(event);
    }
    public static void deleteEvent(){
        System.out.println("Introduce el ID cuyo evento quieres borrar");
        int id = sc.nextInt();
        DeleteEventUseCase useCase = new DeleteEventUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        useCase.execute(id);
    }
    public static void updateEvent(){
        System.out.println("Introduce el ID del evento a modificar");
        int unchangedId = sc.nextInt();

        System.out.println("Nombre del evento");
        String name = sc.nextLine();
        System.out.println("Fecha del evento");
        String date = sc.nextLine();
        System.out.println("Plazas del evento");
        int seats = sc.nextInt();
        sc.nextLine();

        Event updatedEvent = new Event(unchangedId,name,date,seats);
        UpdateEventUseCase useCase = new UpdateEventUseCase(new EventDataRepository( EventMemLocalDataSource.getInstance()));
        useCase.execute(updatedEvent);

    }
    public static void getAllEvents() {
        System.out.println("A continuación se muestra una lista de los eventos de esta semana");
        GetEventsUseCase useCase = new GetEventsUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        List<Event> listaEventos = useCase.execute();
        for (Event element : listaEventos) {
            System.out.println(element.name + " / " + element.date + " / " + element.capacity + " plazas ");
        }
    }

}

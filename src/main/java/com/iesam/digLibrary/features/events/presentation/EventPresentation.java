package com.iesam.digLibrary.features.events.presentation;

import com.iesam.digLibrary.features.events.data.EventDataRepository;
import com.iesam.digLibrary.features.events.data.local.EventMemLocalDataSource;
import com.iesam.digLibrary.features.events.domain.*;

import java.util.List;
import java.util.Scanner;

public class EventPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void createEvent(){
        System.out.println("New event form");
        System.out.println("Enter event ID");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter event name");
        String name = sc.nextLine();
        System.out.println("Enter event date");
        String date = sc.nextLine();
        System.out.println("Enter seats available");
        int seats = sc.nextInt();
        sc.nextLine();

        Event event = new Event(id,name,date,seats);
        SaveEventUseCase useCase = new SaveEventUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        useCase.execute(event);
    }
    public static void deleteEvent(){
        System.out.println("Enter event ID to delete");
        int id = sc.nextInt();
        DeleteEventUseCase useCase = new DeleteEventUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        useCase.execute(id);
    }
    public static void updateEvent(){
        System.out.println("Enter event ID to update");
        int unchangedId = sc.nextInt();
        System.out.println("Update event form");
        System.out.println("Enter event name");
        String name = sc.nextLine();
        System.out.println("Enter event date");
        String date = sc.nextLine();
        System.out.println("Enter seats available");
        int seats = sc.nextInt();
        sc.nextLine();

        Event updatedEvent = new Event(unchangedId,name,date,seats);
        UpdateEventUseCase useCase = new UpdateEventUseCase(new EventDataRepository( EventMemLocalDataSource.getInstance()));
        useCase.execute(updatedEvent);

    }
    public static void getAllEvents() {
        System.out.println("Next a list of our upcoming events wills be shown");
        GetEventsUseCase useCase = new GetEventsUseCase(new EventDataRepository(EventMemLocalDataSource.getInstance()));
        List<Event> eventList = useCase.execute();
        for (Event element : eventList ){
            System.out.println(element.name + " / " + element.date + " / " + element.capacity + " plazas ");
        }
    }

}

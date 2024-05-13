package com.iesam.digLibrary.features.events.domain;

import java.util.List;

public class GetEventsUseCase {
    private EventRepository repository;

    public GetEventsUseCase(EventRepository repository) {
        this.repository = repository;
    }
    public List<Event> execute(){
        return repository.getAllEvents();
    }

}

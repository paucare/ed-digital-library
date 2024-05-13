package com.iesam.digLibrary.features.events.domain;

public class GetEventUseCase {
    private EventRepository repository;

    public GetEventUseCase(EventRepository repository) {
        this.repository = repository;
    }
    public Event execute(int id){
        return repository.getEventById(id);
    }
}

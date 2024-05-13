package com.iesam.digLibrary.features.events.domain;

public class UpdateEventUseCase {
    private EventRepository repository;

    public UpdateEventUseCase(EventRepository repository) {
        this.repository = repository;
    }
    public void execute(Event event){
        repository.updateEvent(event);
    }
}

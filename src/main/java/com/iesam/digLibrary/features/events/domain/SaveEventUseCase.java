package com.iesam.digLibrary.features.events.domain;

public class SaveEventUseCase {
    private EventRepository repository;

    public SaveEventUseCase(EventRepository repository) {
        this.repository = repository;
    }
    public void execute(Event event){
        repository.saveEvent(event);
    }
}

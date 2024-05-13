package com.iesam.digLibrary.features.events.domain;

public class DeleteEventUseCase {
    private EventRepository repository;

    public DeleteEventUseCase(EventRepository repository) {
        this.repository = repository;
    }
    public void execute(int id){
        repository.deleteEventById(id);
    }
}

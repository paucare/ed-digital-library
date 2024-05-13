package com.iesam.digLibrary.features.events.data;

import com.iesam.digLibrary.features.events.data.local.EventLocalDataSource;
import com.iesam.digLibrary.features.events.domain.Event;
import com.iesam.digLibrary.features.events.domain.EventRepository;

import java.util.List;

public class EventDataRepository implements EventRepository {
    private EventLocalDataSource localDataSource;

    //Constructor?
    public EventDataRepository(EventLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }


    @Override
    public void saveEvent(Event event) {
        localDataSource.save(event);
    }

    @Override
    public Event getEventById(int id) {
        return localDataSource.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        localDataSource.delete(event.eventId);
        localDataSource.save(event);
    }

    @Override
    public void deleteEventById(int eventId) {
        localDataSource.delete(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return localDataSource.findAll();
    }
}

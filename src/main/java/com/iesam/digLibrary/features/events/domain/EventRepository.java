package com.iesam.digLibrary.features.events.domain;

import java.util.List;

public interface EventRepository {
    public void saveEvent(Event event);
    public Event getEventById(int id);
    public void updateEvent(Event event);
    public void deleteEventById(int id);
    public List<Event> getAllEvents();
}

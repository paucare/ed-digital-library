package com.iesam.digLibrary.features.events.data.local;

import com.iesam.digLibrary.features.events.domain.Event;

import java.util.List;

public interface EventLocalDataSource {
    public void save(Event event);
    public void saveList(List<Event> models);
    public Event findById(int id);
    public List<Event> findAll();
    public void delete(int id);

}

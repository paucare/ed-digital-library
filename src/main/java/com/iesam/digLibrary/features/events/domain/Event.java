package com.iesam.digLibrary.features.events.domain;

public class Event {

    public final int eventId;
    public final String name;
    public final String date;
    public final int capacity;

    public Event(int eventId, String name, String date, int capacity) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.capacity = capacity;
    }
}




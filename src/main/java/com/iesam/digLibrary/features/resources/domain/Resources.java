package com.iesam.digLibrary.features.resources.domain;

public class Resources {
    public final resourceType type;
    public final int id;
    public final String name;
    public final int year;
    public final String description;

    public Resources(resourceType type, int id, String name, int year, String synopsis) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.year = year;
        this.description = synopsis;
    }
}

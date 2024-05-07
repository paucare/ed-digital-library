package com.iesam.digLibrary.features.resources;

public class Resources {
    public final int id;
    public final String name;
    public final int year;
    public final String description;

    public Resources(int id, String name, int year, String synopsis) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.description = synopsis;
    }
}

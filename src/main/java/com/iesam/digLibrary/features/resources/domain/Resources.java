package com.iesam.digLibrary.features.resources.domain;

public class Resources {
    public final int id;
    public final String name;
    public final String year;
    public final String synopsis;

    public Resources(int id, String name, String year, String synopsis) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.synopsis = synopsis;
    }
}

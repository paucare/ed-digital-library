package com.iesam.digLibrary.features.resources.books.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.resources.domain.resourceType;

public class Books extends Resources {

    public final int extension;
    public Books(int id, String name, int year, String synopsis, int extension) {
        super(resourceType.BOOK, id, name, year, synopsis);
        this.extension = extension;
    }
}

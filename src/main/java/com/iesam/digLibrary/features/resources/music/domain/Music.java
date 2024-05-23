package com.iesam.digLibrary.features.resources.music.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.resources.domain.resourceType;

public class Music extends Resources {
    public final int numSongs;

    public Music(int id, String name, int year, String synopsis, int numSongs) {
        super(resourceType.MUSIC, id, name, year, synopsis);
        this.numSongs = numSongs;
    }
}

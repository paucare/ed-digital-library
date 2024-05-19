package com.iesam.digLibrary.features.resources.music.domain;

import java.util.List;

public class GetAllMusicUseCase {
    MusicRepository repository;

    public GetAllMusicUseCase(MusicRepository repository) {
        this.repository = repository;
    }
    public List<Music> execute(){
        return repository.getAllMusic();
    }
}

package com.iesam.digLibrary.features.resources.music.domain;

public class GetMusicByIdUseCase {
    MusicRepository repository;

    public GetMusicByIdUseCase(MusicRepository repository) {
        this.repository = repository;
    }
    public Music execute(int idMusic){
        return repository.getMusicById(idMusic);
    }

}

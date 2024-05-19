package com.iesam.digLibrary.features.resources.music.domain;

public class DeleteMusicUseCase {
    MusicRepository repository;

    public DeleteMusicUseCase(MusicRepository repository) {
        this.repository = repository;
    }
    public void execute(int musicId){
        repository.deleteMusic(musicId);
    }
}

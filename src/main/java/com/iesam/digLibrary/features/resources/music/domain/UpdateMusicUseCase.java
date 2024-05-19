package com.iesam.digLibrary.features.resources.music.domain;

public class UpdateMusicUseCase {
    MusicRepository repository;

    public UpdateMusicUseCase(MusicRepository repository) {
        this.repository = repository;
    }

    public void execute(Music music){
        repository.updateMusic(music);
    }
}

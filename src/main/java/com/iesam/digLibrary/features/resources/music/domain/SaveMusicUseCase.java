package com.iesam.digLibrary.features.resources.music.domain;

public class SaveMusicUseCase {
    MusicRepository repository;

    public SaveMusicUseCase(MusicRepository repository) {
        this.repository = repository;
    }
    public void execute(Music music){
        repository.saveMusic(music);
    }
}

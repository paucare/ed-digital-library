package com.iesam.digLibrary.features.resources.music.domain;

import java.util.List;

public interface MusicRepository {
    public Music getMusicById(int idMusic);
    public List<Music> getAllMusic();
    public void saveMusic(Music music);
    public void deleteMusic(int idMusic);
    public void updateMusic(Music music);
}

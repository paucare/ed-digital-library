package com.iesam.digLibrary.features.resources.music.data;
import com.iesam.digLibrary.features.resources.music.data.local.MusicFileLocalDataSource;
import com.iesam.digLibrary.features.resources.music.domain.Music;
import com.iesam.digLibrary.features.resources.music.domain.MusicRepository;

import java.util.List;

public class MusicDataRepository implements MusicRepository {

    MusicFileLocalDataSource localDataSource;

    public MusicDataRepository(MusicFileLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public Music getMusicById(int idMusic) {
        return localDataSource.findById(idMusic);
    }

    @Override
    public List<Music> getAllMusic() {
        return localDataSource.findAll();
    }

    @Override
    public void saveMusic(Music music) {
        localDataSource.save(music);
    }

    @Override
    public void deleteMusic(int idMusic) {
        localDataSource.delete(idMusic);
    }

    @Override
    public void updateMusic(Music music) {
        localDataSource.delete(music.id);
        localDataSource.save(music);
    }
}

package com.iesam.digLibrary.features.resources.music.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetAllMusicUseCaseTest {
    @Mock
    MusicRepository repository;
    GetAllMusicUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetAllMusicUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItReturnsMusicList(){
        List<Music> allMusic = new ArrayList<>();
        Music m1 = new Music(1,"X100PRE",2018,"New gen reggaeton",15);
        allMusic.add(m1);
        allMusic.add(m1);
        Mockito.when(repository.getAllMusic()).thenReturn(allMusic);

        List<Music> musicReceived = useCase.execute();

        Assertions.assertEquals(musicReceived.size(),2);
        Assertions.assertEquals(musicReceived.get(0).id,1);
        Assertions.assertEquals(musicReceived.get(0).name,"X100PRE");
        Assertions.assertEquals(musicReceived.get(0).year,2018);
        Assertions.assertEquals(musicReceived.get(0).description,"New gen reggaeton");
        Assertions.assertEquals(musicReceived.get(0).numSongs,15);
        Assertions.assertEquals(musicReceived.get(1).id,1);
        Assertions.assertEquals(musicReceived.get(1).name,"X100PRE");
        Assertions.assertEquals(musicReceived.get(1).year,2018);
        Assertions.assertEquals(musicReceived.get(1).description,"New gen reggaeton");
        Assertions.assertEquals(musicReceived.get(1).numSongs,15);
    }
}
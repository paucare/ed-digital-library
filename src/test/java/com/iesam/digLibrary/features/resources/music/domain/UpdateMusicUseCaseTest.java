package com.iesam.digLibrary.features.resources.music.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateMusicUseCaseTest {
    @Mock
    MusicRepository repository;
    UpdateMusicUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new UpdateMusicUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItUpdatesTheModel(){
        Music musicToUpdate = new Music(1,"X100PRE",2018,"New gen reggaeton",15);
        useCase.execute(musicToUpdate);
        Mockito.verify(repository,Mockito.times(1)).updateMusic(musicToUpdate);
    }

}
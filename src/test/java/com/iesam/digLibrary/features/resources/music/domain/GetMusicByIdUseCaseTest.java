package com.iesam.digLibrary.features.resources.music.domain;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetMusicByIdUseCaseTest {
    @Mock
    MusicRepository repository;
    GetMusicByIdUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new GetMusicByIdUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItReturnsAModel(){
        Music musicExpected = new Music(1,"X100PRE",2018,"New gen reggaeton",15);
        Mockito.when(repository.getMusicById(1)).thenReturn(musicExpected);
        Music musicReceived = useCase.execute(1);
        Assertions.assertEquals(musicReceived.id,1);
        Assertions.assertEquals(musicReceived.name,"X100PRE");
        Assertions.assertEquals(musicReceived.year,2018);
        Assertions.assertEquals(musicReceived.description,"New gen reggaeton");
        Assertions.assertEquals(musicReceived.numSongs,15);
    }
}
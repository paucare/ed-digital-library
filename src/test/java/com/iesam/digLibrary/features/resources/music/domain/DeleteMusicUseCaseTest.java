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
class DeleteMusicUseCaseTest {
    @Mock
    MusicRepository repository;
    DeleteMusicUseCase useCase;
    @BeforeEach
    void setUp() {
        useCase = new DeleteMusicUseCase(repository);
    }

    @AfterEach
    void tearDown() {
        useCase = null;
    }
    @Test
    public void whenUseCaseIsExecutedItDeletesTheModel(){
        int idToDelete = 1;

        useCase.execute(idToDelete);

        Mockito.verify(repository,Mockito.times(1)).deleteMusic(idToDelete);
    }

}
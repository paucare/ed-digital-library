package com.iesam.digLibrary.features.user.data;

import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class UserDataRepositoryTest {
    @Mock
    UserFileLocalDataSource localDataSource;

    UserDataRepository dataRepository;
    @BeforeEach
    void setUp(){
        dataRepository = new UserDataRepository(localDataSource);
    }
    @AfterEach
    void tearDown(){
        dataRepository = null;
    }

    @Test
    public void getUserMethodCallsLocalDataSource(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        Mockito.when(localDataSource.findById(user.dni)).thenReturn(user);
        //When
        User userRetrieved = dataRepository.getUserById(user.dni);
        //Then
        Assertions.assertEquals(userRetrieved.dni,"8001");
        Assertions.assertEquals(userRetrieved.name,"User");
        Assertions.assertEquals(userRetrieved.surname,"Surname");
        Assertions.assertEquals(userRetrieved.phoneNumber,123);
        Assertions.assertEquals(userRetrieved.address,"Address");
    }

    @Test
    public void deleteUserMethodCallsLocalDataSource(){
        //Given
        String idToDelete = "123";
        //When
        dataRepository.deleteUser(idToDelete);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).delete(idToDelete);
    }
    @Test
    public void saveUserMethodCallsLocalDataSource(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        //When
        dataRepository.saveUser(user);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).save(user);
    }
    @Test
    public void updateUserCallsLocalDataSourceTwice(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        //When
        dataRepository.deleteUser(user.dni);
        dataRepository.saveUser(user);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).delete(user.dni);
        Mockito.verify(localDataSource,Mockito.times(1)).save(user);
    }
}
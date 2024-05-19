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

    @Test
    public void getUserMethodCallsLocalDataSource(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        Mockito.when(localDataSource.findById(user.dni)).thenReturn(user);
        //When
        User userRetrieved = localDataSource.findById(user.dni);
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
        localDataSource.delete(idToDelete);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).delete(idToDelete);
    }
    @Test
    public void saveUserMethodCallsLocalDataSource(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        //When
        localDataSource.save(user);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).save(user);
    }
    @Test
    public void updateUserCallsLocalDataSourceTwice(){
        //Given
        User user = new User("8001","User","Surname",123,"Address");
        //When
        localDataSource.delete(user.dni);
        localDataSource.save(user);
        //Then
        Mockito.verify(localDataSource,Mockito.times(1)).delete(user.dni);
        Mockito.verify(localDataSource,Mockito.times(1)).save(user);
    }
}
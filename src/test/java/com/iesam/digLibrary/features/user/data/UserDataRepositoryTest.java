package com.iesam.digLibrary.features.user.data;

import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.data.local.UserMemLocalDataSource;
import com.iesam.digLibrary.features.user.domain.User;
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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith({MockitoExtension.class})
class UserDataRepositoryTest {
    @Mock
    UserFileLocalDataSource localDataSource;
    @Mock
    UserMemLocalDataSource memLocalDataSource;

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
    @Test
    public void getUsersCallsLocalDataSource() {
        List<User> allUsers = new ArrayList<>();
        User u1 = new User("ABC123", "Name", "Surname", 123, "Address");
        allUsers.add(u1);
        allUsers.add(u1);
        Mockito.when(localDataSource.findAll()).thenReturn(allUsers);

        List<User> usersReceived = dataRepository.getAllUsers();

        Assertions.assertEquals(usersReceived.size(), 2);
        Assertions.assertEquals(usersReceived.get(0).dni, "ABC123");
        Assertions.assertEquals(usersReceived.get(0).name, "Name");
        Assertions.assertEquals(usersReceived.get(0).surname, "Surname");
        Assertions.assertEquals(usersReceived.get(0).phoneNumber, 123);
        Assertions.assertEquals(usersReceived.get(0).address, "Address");
        Assertions.assertEquals(usersReceived.get(1).dni, "ABC123");
        Assertions.assertEquals(usersReceived.get(1).name, "Name");
        Assertions.assertEquals(usersReceived.get(1).surname, "Surname");
        Assertions.assertEquals(usersReceived.get(1).phoneNumber, 123);
        Assertions.assertEquals(usersReceived.get(1).address, "Address");
    }
    @Test
    public void givenUserExistsInMemory_whenGetUserById_thenFileDataSourceIsNotCalled(){

        User user = new User("8001","User","Surname",123,"Address");

        Mockito.when(memLocalDataSource.findById(any())).thenReturn(user);

        dataRepository = new UserDataRepository(localDataSource,memLocalDataSource);

        User userRetrieved = memLocalDataSource.findById("8001");

        Mockito.verify(localDataSource, Mockito.times(0)).findById("8001");

        Assertions.assertEquals(userRetrieved.dni,"8001");
        Assertions.assertEquals(userRetrieved.name,"User");
        Assertions.assertEquals(userRetrieved.surname,"Surname");
        Assertions.assertEquals(userRetrieved.phoneNumber,123);
        Assertions.assertEquals(userRetrieved.address,"Address");
        dataRepository = null;
    }
    @Test
    public void givenUsersExistsInMemory_whenGetAllUsers_thenFileDataSourceIsNotCalled(){
        List<User> allUsers = new ArrayList<>();
        User u1 = new User("8001","User","Surname",123,"Address");
        allUsers.add(u1);
        allUsers.add(u1);

        Mockito.when(memLocalDataSource.findAll()).thenReturn(allUsers);

        dataRepository = new UserDataRepository(localDataSource,memLocalDataSource);

        List<User> listRetrieved = memLocalDataSource.findAll();

        Mockito.verify(localDataSource,Mockito.times(0)).findAll();

        Assertions.assertEquals(listRetrieved.size(),2);
        Assertions.assertEquals(listRetrieved.get(0).dni,"8001");
        Assertions.assertEquals(listRetrieved.get(0).name,"User");
        Assertions.assertEquals(listRetrieved.get(0).surname,"Surname");
        Assertions.assertEquals(listRetrieved.get(0).phoneNumber,123);
        Assertions.assertEquals(listRetrieved.get(0).address,"Address");
        Assertions.assertEquals(listRetrieved.get(1).dni,"8001");
        Assertions.assertEquals(listRetrieved.get(1).name,"User");
        Assertions.assertEquals(listRetrieved.get(1).surname,"Surname");
        Assertions.assertEquals(listRetrieved.get(1).phoneNumber,123);
        Assertions.assertEquals(listRetrieved.get(1).address,"Address");

        dataRepository = null;
    }

}
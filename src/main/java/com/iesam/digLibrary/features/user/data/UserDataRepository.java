package com.iesam.digLibrary.features.user.data;

import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.data.local.UserMemLocalDataSource;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {
    private UserFileLocalDataSource localDataSource;

    public UserDataRepository(UserFileLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void saveUser(User user) {
        localDataSource.save(user);
    }
  
    @Override
    public void deleteUser(String dni) {
        localDataSource.delete(dni);
        UserMemLocalDataSource.getInstance().delete(dni);
    }

    @Override
    public void updateUser(User user) {
        deleteUser(user.dni);
        saveUser(user);
    }

    @Override
    public User getUserById(String id) {

        User user = UserMemLocalDataSource.getInstance().findById(id);

        if(user==null){
            user = localDataSource.findById(id);
            UserMemLocalDataSource.getInstance().save(user);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList =  UserMemLocalDataSource.getInstance().findAll();

        if(userList.isEmpty()) {
            userList = localDataSource.findAll();
            for ( User element: userList){
                UserMemLocalDataSource.getInstance().save(element);
            }
        }
            return userList;
    }
}

package com.iesam.digLibrary.features.user.data;

import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.data.local.UserMemLocalDataSource;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.user.domain.UserRepository;

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
        User memUser = UserMemLocalDataSource.getInstance().findById(id);
        User fileUser = localDataSource.findById(id);

        if (memUser != null) {
            return memUser;

        } else if(fileUser!=null){
            UserMemLocalDataSource.getInstance().save(fileUser);
            return fileUser;

        } else {
            System.out.println("Data not found");
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> memUserList =  UserMemLocalDataSource.getInstance().findAll();

        if(memUserList!= null) {
            return memUserList;

        } else if(!localDataSource.findAll().isEmpty()){
            List<User> fileUserList = localDataSource.findAll();
            for ( User element: fileUserList){
                UserMemLocalDataSource.getInstance().save(element);
            }
            return fileUserList;
        } else {
            System.out.println("Data not found");
            return null;
        }
    }
}

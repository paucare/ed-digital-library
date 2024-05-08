package com.iesam.digLibrary.features.user.data;

import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.user.domain.UserRepository;

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
    }

    @Override
    public void updateUser(User user) {
        deleteUser(user.dni);
        saveUser(user);
    }

    @Override
    public User getUserById(String id) {
        return  localDataSource.findById(id);
    }
}

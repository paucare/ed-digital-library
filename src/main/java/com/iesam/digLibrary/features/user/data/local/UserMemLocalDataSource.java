package com.iesam.digLibrary.features.user.data.local;

import com.iesam.digLibrary.features.user.domain.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserMemLocalDataSource {
    private static UserMemLocalDataSource instance = null;

    public UserMemLocalDataSource() {
    }

    private Map<String, User> dataStore = new TreeMap<>();

    public void save(User model) {
        dataStore.put(model.dni, model);
    }

    public void saveList(List<User> models) {
        for (User User : models) {
            save(User);
        }
    }

    public User findById(String id) {
        return dataStore.get(id);
    }

    public List<User> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }
    public static UserMemLocalDataSource getInstance(){
        if(instance==null){
            instance= new UserMemLocalDataSource();
        }
        return instance;
    }
}

package com.iesam.digLibrary.features.user.domain;

public interface UserRepository {
    public void saveUser(User user);

    public void deleteUser(String dni);

    public void updateUser(User user);
    public void getUser(String id);
}



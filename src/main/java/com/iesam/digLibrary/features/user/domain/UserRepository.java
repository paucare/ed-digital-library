package com.iesam.digLibrary.features.user.domain;

import java.util.List;

public interface UserRepository {
    public void saveUser(User user);

    public void deleteUser(String dni);

    public void updateUser(User user);
    public User getUserById(String id);
    public List<User> getAllUsers();
}



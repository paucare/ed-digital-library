package com.iesam.digLibrary.features.user.domain;

import com.iesam.digLibrary.features.exceptions.NotValidInputException;

public class SaveUserUseCase {
    public final UserRepository repository;

    public SaveUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(User user) {
        User existingUser = repository.getUserById(user.dni);
        if(existingUser == null){
            repository.saveUser(user);
        } else {
            throw  new NotValidInputException("A user with said ID already exists");
        }
    }
}

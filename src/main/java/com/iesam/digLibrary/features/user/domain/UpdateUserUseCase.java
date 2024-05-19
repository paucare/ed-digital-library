package com.iesam.digLibrary.features.user.domain;

import com.iesam.digLibrary.features.exceptions.NotValidInputException;

public class UpdateUserUseCase {
    public final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(User user){

        User existingUser = repository.getUserById(user.dni);

        if(existingUser != null){
            repository.updateUser(user);
        } else {
            throw new NotValidInputException("The user does not exist");
        }

    }
}

package com.iesam.digLibrary.features.user.domain;

import com.iesam.digLibrary.features.exceptions.NotValidInputException;

public class DeleteUserUseCase {
    public final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String dni) {
        User existingUser = repository.getUserById(dni);
        if(existingUser!=null) {
            repository.deleteUser(dni);
        } else {
            throw new NotValidInputException("Ese usuario no existe");
        }
    }
}

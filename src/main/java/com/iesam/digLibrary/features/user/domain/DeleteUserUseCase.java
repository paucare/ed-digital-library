package com.iesam.digLibrary.features.user.domain;

public class DeleteUserUseCase {
    private UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String dni) {

        User existingUser = repository.getUserById(dni);
        if(existingUser!=null) {
            repository.deleteUser(dni);
        }
    }
}

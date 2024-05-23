package com.iesam.digLibrary.features.user.domain;

public class DeleteUserUseCase {
    private UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String dni) {
            repository.deleteUser(dni);
    }
}

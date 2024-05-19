package com.iesam.digLibrary.features.user.domain;

public class DeleteUserUseCase {
    public final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String dni) {
        repository.deleteUser(dni);
    }
}

package com.iesam.digLibrary.features.user.domain;

public class UpdateUserUseCase {
    public final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(User user){
        repository.updateUser(user);
    }
}

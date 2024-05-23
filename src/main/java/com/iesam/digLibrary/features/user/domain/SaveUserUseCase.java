package com.iesam.digLibrary.features.user.domain;



public class SaveUserUseCase {
    private UserRepository repository;

    public SaveUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(User user) {
            repository.saveUser(user);
    }
}

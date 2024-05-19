package com.iesam.digLibrary.features.user.domain;



public class SaveUserUseCase {
    public final UserRepository repository;

    public SaveUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(User user) {
        User existingUser = repository.getUserById(user.dni);
        if(existingUser == null){
            repository.saveUser(user);
        }
    }
}

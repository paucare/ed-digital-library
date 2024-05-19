package com.iesam.digLibrary.features.user.domain;



public class UpdateUserUseCase {
    public final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(User user){

        User existingUser = repository.getUserById(user.dni);

        if(existingUser != null){
            repository.updateUser(user);
        }

    }
}

package com.iesam.digLibrary.features.user.domain;

public class GetUserByIdUseCase {
    private final UserRepository repository;

    public GetUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public User execute(String id){
        return repository.getUserById(id);
    }
}

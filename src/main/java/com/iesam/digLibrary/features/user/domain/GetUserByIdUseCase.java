package com.iesam.digLibrary.features.user.domain;

public class GetUserByIdUseCase {
    private UserRepository repository;

    public GetUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(String id){
        return getUserById(id);
    }
}

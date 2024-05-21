package com.iesam.digLibrary.features.user.domain;

import java.util.List;

public class GetUsersUseCase {
    private UserRepository repository;

    public GetUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public List<User> execute(){
        return repository.getAllUsers();
    }
}

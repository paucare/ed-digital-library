package com.iesam.digLibrary.features.resources.domain;

public class DeleteResourceUseCase {
    private ResourcesRepository repository;

    public DeleteResourceUseCase(ResourcesRepository repository) {
        this.repository = repository;
    }
    public void execute(int id){
        repository.deleteResource(id);
    }
}

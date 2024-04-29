package com.iesam.digLibrary.features.resources.domain;

public class SaveResourceUseCase {
    public final ResourcesRepository repository;

    public SaveResourceUseCase(ResourcesRepository repository) {
        this.repository = repository;
    }
    public void execute(Resources resource){
        repository.saveResource(resource);
    }
}

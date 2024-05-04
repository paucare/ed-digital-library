package com.iesam.digLibrary.features.resources.domain;

public class GetResourceByIdUseCase {
    private ResourcesRepository repository;

    public GetResourceByIdUseCase(ResourcesRepository repository) {
        this.repository = repository;
    }
    public Resources getResourceById(int id){
        return getResourceById(id);
    }
}

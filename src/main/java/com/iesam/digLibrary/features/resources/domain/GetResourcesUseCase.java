package com.iesam.digLibrary.features.resources.domain;

import java.util.List;
import java.util.ArrayList;
public class GetResourcesUseCase {
    private ResourcesRepository repository;

    public GetResourcesUseCase(ResourcesRepository repository) {
        this.repository = repository;
    }
    public List<Resources> execute(){
        return repository.getAllResources();
    }
}

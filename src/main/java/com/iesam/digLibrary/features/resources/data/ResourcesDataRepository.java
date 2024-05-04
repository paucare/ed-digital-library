package com.iesam.digLibrary.features.resources.data;

import com.iesam.digLibrary.features.resources.data.local.ResourcesFileLocalDataSource;
import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.resources.domain.ResourcesRepository;

import java.util.List;
import java.util.ArrayList;


public class ResourcesDataRepository implements ResourcesRepository {

    private ResourcesFileLocalDataSource localDataSource;

    public ResourcesDataRepository(ResourcesFileLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void saveResource(Resources resource) {
        localDataSource.save(resource);
    }

    @Override
    public void deleteResource(int id) {
        localDataSource.delete(id);
    }

    @Override
    public List<Resources> getAllResources() {
        return localDataSource.findAll();
    }

    @Override
    public Resources getResourceById(int id) {
        return localDataSource.findById(id);
    }
}

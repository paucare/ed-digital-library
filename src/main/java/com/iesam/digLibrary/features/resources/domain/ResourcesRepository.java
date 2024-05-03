package com.iesam.digLibrary.features.resources.domain;

import java.util.List;

public interface ResourcesRepository {
    public void saveResource(Resources resource);
    public void deleteResource(int id);
    public List<Resources> getAllResources();
}

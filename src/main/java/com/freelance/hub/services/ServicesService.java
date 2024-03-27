package com.freelance.hub.services;

import com.freelance.hub.model.entity.Services;

import java.util.List;
import java.util.Optional;

public interface ServicesService {
    void saveServices(Services services);
    Optional<Services> findById(String id);
    void updateServices(Services services);
    void deleteById(String id);
    List<Services> findAllNotDeleted();
}

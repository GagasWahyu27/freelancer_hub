package com.freelance.hub.services.impl;

import com.freelance.hub.model.entity.Services;
import com.freelance.hub.repository.ServicesRepository;
import com.freelance.hub.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicesServiceImpl implements ServicesService {

    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public void saveServices(Services services) {
        if (services.getFreelancer() != null) {
            services.setId(UUID.randomUUID().toString());
            servicesRepository.saveServices(
                    services.getId(),
                    services.getServiceName(),
                    services.getHidden(),
                    services.getDescription(),
                    services.getFreelancer().getId()
            );
        } else {
            throw new IllegalArgumentException("Freelancer cannot be null");
        }
    }

    @Override
    public Optional<Services> findById(String id) {
        return servicesRepository.findById(id);
    }

    @Override
    public void updateServices(Services services) {
        servicesRepository.updateServices(
                services.getId(),
                services.getServiceName(),
                services.getHidden(),
                services.getDescription()
        );
    }

    @Override
    public void deleteById(String id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public List<Services> findAllNotDeleted() {
        return servicesRepository.findAllNotDeleted();
    }
}

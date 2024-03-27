package com.freelance.hub.services;

import com.freelance.hub.model.entity.Freelancer;

import java.util.List;
import java.util.Optional;

public interface FreelancerService {
    void saveFreelancer(Freelancer freelancer);
    Optional<Freelancer> findByIdAndDeletedFalse(String id);
    void updateFreelancer(Freelancer freelancer);
    void deleteById(String id);
    List<Freelancer> findAllNotDeleted();
}

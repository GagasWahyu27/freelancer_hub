package com.freelance.hub.services.impl;

import com.freelance.hub.model.entity.Freelancer;
import com.freelance.hub.repository.FreelancerRepository;
import com.freelance.hub.services.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    private final FreelancerRepository freelancerRepository;

    @Autowired
    public FreelancerServiceImpl(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public void saveFreelancer(Freelancer freelancer) {
        freelancer.setId(UUID.randomUUID().toString());
        freelancer.setCreatedAccount(new Date());
        freelancerRepository.saveFreelancer(
                freelancer.getId(),
                freelancer.getEmail(),
                freelancer.getPassword(),
                freelancer.getName(),
                freelancer.getAddress(),
                freelancer.getPhoneNumber(),
                freelancer.getBio(),
                freelancer.getCreatedAccount(),
                freelancer.getDeleted());
    }

    public Optional<Freelancer> findByIdAndDeletedFalse(String id) {
        return freelancerRepository.findByIdAndDeletedFalse(id);
    }

    public void updateFreelancer(Freelancer freelancer) {
        freelancerRepository.updateFreelancer(
                freelancer.getId(),
                freelancer.getEmail(),
                freelancer.getPassword(),
                freelancer.getName(),
                freelancer.getAddress(),
                freelancer.getPhoneNumber(),
                freelancer.getBio());
    }

    public void deleteById(String id) {
        freelancerRepository.deleteById(id);
    }

    public List<Freelancer> findAllNotDeleted() {
        return freelancerRepository.findAllNotDeleted();
    }
}

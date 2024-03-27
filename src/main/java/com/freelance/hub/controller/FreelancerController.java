package com.freelance.hub.controller;

import com.freelance.hub.model.entity.Freelancer;
import com.freelance.hub.services.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/freelancers")
public class FreelancerController {

    private final FreelancerService freelancerService;

    @Autowired
    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @PostMapping
    public ResponseEntity<String> createFreelancer(@RequestBody Freelancer freelancer) {
        freelancerService.saveFreelancer(freelancer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Freelancer created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freelancer> getFreelancerById(@PathVariable String id) {
        Optional<Freelancer> freelancer = freelancerService.findByIdAndDeletedFalse(id);
        return freelancer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFreelancer(@PathVariable String id, @RequestBody Freelancer freelancer) {
        freelancer.setId(id);
        freelancerService.updateFreelancer(freelancer);
        return ResponseEntity.ok("Freelancer updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFreelancer(@PathVariable String id) {
        freelancerService.deleteById(id);
        return ResponseEntity.ok("Freelancer deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Freelancer>> getAllFreelancers() {
        List<Freelancer> freelancers = freelancerService.findAllNotDeleted();
        return ResponseEntity.ok(freelancers);
    }
}

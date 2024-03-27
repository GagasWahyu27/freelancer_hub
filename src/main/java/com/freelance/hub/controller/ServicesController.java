package com.freelance.hub.controller;

import com.freelance.hub.model.entity.Services;
import com.freelance.hub.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ResponseEntity<String> createServices(@RequestBody Services services) {
        servicesService.saveServices(services);
        return ResponseEntity.status(HttpStatus.CREATED).body("Services created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable String id) {
        Optional<Services> services = servicesService.findById(id);
        return services.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateServices(@PathVariable String id, @RequestBody Services services) {
        services.setId(id);
        servicesService.updateServices(services);
        return ResponseEntity.ok("Services updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServices(@PathVariable String id) {
        servicesService.deleteById(id);
        return ResponseEntity.ok("Services deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = servicesService.findAllNotDeleted();
        return ResponseEntity.ok(services);
    }
}

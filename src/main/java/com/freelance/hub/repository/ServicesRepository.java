package com.freelance.hub.repository;

import com.freelance.hub.model.entity.Freelancer;
import com.freelance.hub.model.entity.Services;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO services (services_id, service_name, hidden, description, freelancer_id) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveServices(String id, String serviceName, boolean hidden, String description, String freelancerId);

    @Query(value = "SELECT * FROM services WHERE services_id = ?1 AND hidden = false", nativeQuery = true)
    Optional<Services> findByIdAndDeletedFalse(String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE services SET service_name = ?2, hidden = ?3, description = ?4 WHERE services_id = ?1", nativeQuery = true)
    void updateServices(String id, String serviceName, boolean hidden, String description);

    @Transactional
    @Modifying
    @Query(value = "UPDATE services SET hidden = true WHERE services_id = ?1", nativeQuery = true)
    void deleteById(String id);

    @Query(value = "SELECT * FROM services WHERE hidden = false", nativeQuery = true)
    List<Services> findAllNotDeleted();
}

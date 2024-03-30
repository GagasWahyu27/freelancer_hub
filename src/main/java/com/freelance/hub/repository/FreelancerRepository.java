package com.freelance.hub.repository;

import com.freelance.hub.model.entity.Freelancer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO mst_freelancer (freelancer_id, email, password, name, address, phone_number, bio, created_account, deleted) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveFreelancer(String id, String email, String password, String name, String address, String phoneNumber, String bio, Date createdAccount, Boolean deleted);

    @Query(value = "SELECT * FROM mst_freelancer WHERE freelancer_id = ?1 AND deleted = false", nativeQuery = true)
    Optional<Freelancer> findByIdAndDeletedFalse(String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE mst_freelancer SET email = ?2, password = ?3, name = ?4, address = ?5, phone_number = ?6, bio = ?7 WHERE freelancer_id = ?1", nativeQuery = true)
    void updateFreelancer(String id, String email, String password, String name, String address, String phoneNumber, String bio);

    @Transactional
    @Modifying
    @Query(value = "UPDATE mst_freelancer SET deleted = true WHERE freelancer_id = ?1", nativeQuery = true)
    void deleteById(String id);

    @Query(value = "SELECT * FROM mst_freelancer WHERE deleted = false", nativeQuery = true)
    List<Freelancer> findAllNotDeleted();
}

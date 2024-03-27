package com.freelance.hub.repository;

import com.freelance.hub.constant.ECategory;
import com.freelance.hub.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query(value = "SELECT * FROM category WHERE name = ?1", nativeQuery = true)
    Optional<Category> findByName(ECategory category);

    @Modifying
    @Query(value = "INSERT INTO category (category_id, name) VALUES (?1, ?2)", nativeQuery = true)
    void saveAllAndFlush(String id, ECategory name);
}

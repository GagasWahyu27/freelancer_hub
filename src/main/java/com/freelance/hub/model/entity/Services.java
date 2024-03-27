package com.freelance.hub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
@SQLDelete(sql = "UPDATE services SET deleted = true WHERE services_id = ?")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "services_id")
    private String id;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private Boolean hidden = Boolean.FALSE;

    private String description;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "service_category",
        joinColumns = @JoinColumn(name = "services_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;
}

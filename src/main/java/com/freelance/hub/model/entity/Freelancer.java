package com.freelance.hub.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freelance.hub.constant.ECategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mst_freelancer")
@SQLDelete(sql = "UPDATE mst_freelancer SET deleted = true WHERE freelancer_id = ?")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "freelancer_id")
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    private String bio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdAccount;

    private Boolean deleted = Boolean.FALSE;
}

package com.freelance.hub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FreelancerDTO {
    private String email;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String bio;
}

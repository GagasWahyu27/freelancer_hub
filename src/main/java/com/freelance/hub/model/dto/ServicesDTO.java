package com.freelance.hub.model.dto;

import com.freelance.hub.model.entity.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicesDTO {
    private String serviceName;
    private String description;
    private Freelancer freelancerId;
}

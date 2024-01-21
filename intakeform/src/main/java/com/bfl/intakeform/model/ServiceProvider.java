package com.bfl.intakeform.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Service
@Entity
@Table
public class ServiceProvider extends AbstractContactInfo {

    @Getter @Setter
    private String serviceProviderName;

    @ManyToMany(mappedBy = "serviceProviders")
    private final List<Client> clients = new ArrayList<>();

    @ManyToMany
    private final List<ResourceCategory> resourceCategories = new ArrayList<ResourceCategory>().stream().distinct().collect(Collectors.toList());



}

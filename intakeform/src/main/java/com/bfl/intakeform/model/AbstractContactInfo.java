package com.bfl.intakeform.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
abstract class AbstractContactInfo {


    @Id
    @GeneratedValue
    private long id;

    // @NotBlank
    private String firstName;

    // @NotBlank
    private String lastName;

    // @NotBlank
    private String address;

    // @NotBlank
    // @NotNull
    private int zip;

    // @NotEmpty
    // @NotBlank
    @Size(max = 2)
    private String state;

    // @NotEmpty
    // @NotBlank
    private String phoneNumber;

    
    private String altPhoneNumber;

    @Email
    private String email;


}

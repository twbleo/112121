package com.example.hospitalsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String dateOfBirth;
    private String cpf;
    private String healthPlan;

    @OneToMany(mappedBy = "patient")
    private Set<Prescription> prescriptions;


    // Getters and Setters
}
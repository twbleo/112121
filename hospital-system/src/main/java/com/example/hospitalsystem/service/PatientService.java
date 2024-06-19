// src/main/java/com/example/hospitalsystem/service/PatientService.java
package com.example.hospitalsystem.service;

import com.example.hospitalsystem.model.Patient;
import com.example.hospitalsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}

// src/main/java/com/example/hospitalsystem/repository/PatientRepository.java
package com.example.hospitalsystem.repository;

import com.example.hospitalsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

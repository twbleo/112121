// src/main/java/com/example/hospitalsystem/repository/PrescriptionRepository.java
package com.example.hospitalsystem.repository;

import com.example.hospitalsystem.model.Doctor;
import com.example.hospitalsystem.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByDoctor(Doctor doctor);
}

package com.example.hospitalsystem.repository;

import com.example.hospitalsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);
}
// src/main/java/com/example/hospitalsystem/repository/PharmacyRepository.java
package com.example.hospitalsystem.repository;

import com.example.hospitalsystem.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Optional<Pharmacy> findByCnpj(String cnpj);
}

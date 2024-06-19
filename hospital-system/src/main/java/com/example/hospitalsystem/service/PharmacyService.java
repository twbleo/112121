// src/main/java/com/example/hospitalsystem/service/PharmacyService.java
package com.example.hospitalsystem.service;

import com.example.hospitalsystem.model.Pharmacy;
import com.example.hospitalsystem.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Pharmacy> findByCnpj(String cnpj) {
        return pharmacyRepository.findByCnpj(cnpj);
    }

    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        pharmacy.setPassword(passwordEncoder.encode(pharmacy.getPassword()));
        return pharmacyRepository.save(pharmacy);
    }
}

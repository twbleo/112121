// src/main/java/com/example/hospitalsystem/service/PrescriptionService.java
package com.example.hospitalsystem.service;

import com.example.hospitalsystem.model.Doctor;
import com.example.hospitalsystem.model.Prescription;
import com.example.hospitalsystem.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime; // Certifique-se de que isto está importado
import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription) {
        prescription.setTimestamp(LocalDateTime.now());
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> findByDoctor(Doctor doctor) {
        return prescriptionRepository.findByDoctor(doctor);
    }
}

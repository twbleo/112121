// src/main/java/com/example/hospitalsystem/controller/DoctorController.java
package com.example.hospitalsystem.controller;

import com.example.hospitalsystem.model.Doctor;
import com.example.hospitalsystem.model.Patient;
import com.example.hospitalsystem.model.Prescription;
import com.example.hospitalsystem.service.DoctorService;
import com.example.hospitalsystem.service.PatientService;
import com.example.hospitalsystem.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/newPrescription")
    public String showNewPrescriptionForm(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "newPrescription";
    }

    @PostMapping("/newPrescription")
    public String createPrescription(@RequestParam Long patientId, @RequestParam String medication,
                                     @RequestParam String dosage, @RequestParam String quantity,
                                     @RequestParam String administrationRoute, @RequestParam String observations,
                                     Principal principal) {
        Doctor doctor = doctorService.findByUsername(principal.getName());
        Patient patient = patientService.findById(patientId).orElse(null);

        if (patient != null) {
            Prescription prescription = new Prescription();
            prescription.setDoctor(doctor);
            prescription.setPatient(patient);
            prescription.setMedication(medication);
            prescription.setDosage(dosage);
            prescription.setQuantity(quantity);
            prescription.setAdministrationRoute(administrationRoute);
            prescription.setObservations(observations); // Este método deve existir

            prescriptionService.savePrescription(prescription);
        }

        return "redirect:/doctor/prescriptions";
    }

    @GetMapping("/prescriptions")
    public String viewPrescriptions(Model model, Principal principal) {
        Doctor doctor = doctorService.findByUsername(principal.getName());
        model.addAttribute("prescriptions", prescriptionService.findByDoctor(doctor));
        return "prescriptions";
    }
}

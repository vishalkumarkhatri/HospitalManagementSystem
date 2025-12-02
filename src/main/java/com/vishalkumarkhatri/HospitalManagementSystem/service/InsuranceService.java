package com.vishalkumarkhatri.HospitalManagementSystem.service;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Insurance;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.Patient;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.InsuranceRepository;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceOfPatient(Insurance insurance, long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency maintenance

        return patient;
    }

    public Patient disaccosiateInsuranceFromPatient(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(null);

        return patient;
    }
}

package com.vishalkumarkhatri.HospitalManagementSystem.service;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Appointment;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.Doctor;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.Patient;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.AppointmentRepository;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.DoctorRepository;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, long doctorId, long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have id");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // to maintain consistency
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(long appointmentId, long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty now.

        doctor.getAppointmentList().add(appointment); // for bidirectional consistency

        return appointment;
    }

}

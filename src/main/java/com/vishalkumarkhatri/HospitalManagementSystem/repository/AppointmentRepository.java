package com.vishalkumarkhatri.HospitalManagementSystem.repository;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
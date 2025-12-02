package com.vishalkumarkhatri.HospitalManagementSystem.repository;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
package com.vishalkumarkhatri.HospitalManagementSystem.repository;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
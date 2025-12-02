package com.vishalkumarkhatri.HospitalManagementSystem.repository;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
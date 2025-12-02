package com.vishalkumarkhatri.HospitalManagementSystem;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Insurance;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.Patient;
import com.vishalkumarkhatri.HospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();
        Patient patient = insuranceService.assignInsuranceOfPatient(insurance, 5);
        System.out.println(patient);

        Patient patient1 = insuranceService.disaccosiateInsuranceFromPatient(patient.getId());

        System.out.println(patient1);

    }


}

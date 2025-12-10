package com.vishalkumarkhatri.HospitalManagementSystem;

import com.vishalkumarkhatri.HospitalManagementSystem.dto.BloodGroupCountResponseEntity;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.Patient;
import com.vishalkumarkhatri.HospitalManagementSystem.entity.type.BloodGroupType;
import com.vishalkumarkhatri.HospitalManagementSystem.repository.PatientRepository;
import com.vishalkumarkhatri.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;


    @Test
    public void testPatientRepository(){
//        List<Patient> patientList = patientRepository.findAll();
        List<Patient> patientList = patientRepository.findAllpatientAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionsMethod() {
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);

//        Patient patient = patientRepository.findByName("Karan Singh");
//        System.out.println(patient);

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1997,12, 18),"meera.kapoor@gmail.com");
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientListContaining = patientRepository.findByBirthDateBetween(LocalDate.of(1997,01,01), LocalDate.of(2000,12,31));
//        for(Patient patient:patientListContaining){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_Negative);
//        for(Patient patient:patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1997, 01, 01));
//        for (Patient patient : patientList) {
//            System.out.println("Name: " + patient.getName() + ", Birth Date: " + patient.getBirthDate());
//        }


//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (Object[] objects : bloodGroupList) {
//            System.out.println(objects[0] + " " + objects[1]);
//        }


        Page<Patient> listOfAllPatient = patientRepository.findAllPatient(PageRequest.of(0, 2, Sort.by("name")));
        for (Patient patient : listOfAllPatient) {
            System.out.println(patient);
        }

//        int rawsUpdated = patientRepository.updateNameWithId("Aarav Mehra", 1);
//        System.out.println(rawsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponseEntity : bloodGroupList) {
//            System.out.println(bloodGroupCountResponseEntity);
//        }


    }
}

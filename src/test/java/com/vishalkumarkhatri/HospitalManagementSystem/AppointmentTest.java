package com.vishalkumarkhatri.HospitalManagementSystem;

import com.vishalkumarkhatri.HospitalManagementSystem.entity.Appointment;
import com.vishalkumarkhatri.HospitalManagementSystem.service.AppointmentService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public  void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 12, 3, 14, 0, 0))
                .reason("Heart")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 1, 5);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3);
    }

}

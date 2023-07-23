package com.neyaz.DoctorAPP.repository;

import com.neyaz.DoctorAPP.model.Appointment;
import com.neyaz.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {

    Appointment findFirstByPatient(Patient patient);
}

package com.neyaz.DoctorAPP.repository;

import com.neyaz.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

    Patient findFirstByPatientEmail(String newEmail);
}

package com.neyaz.DoctorAPP.repository;

import com.neyaz.DoctorAPP.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
}

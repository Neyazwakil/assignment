package com.neyaz.DoctorAPP.repository;

import com.neyaz.DoctorAPP.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}

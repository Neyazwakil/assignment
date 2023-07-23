package com.neyaz.DoctorAPP.repository;

import com.neyaz.DoctorAPP.model.AuthenticationToken;
import com.neyaz.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByPatient(Patient patient);
}

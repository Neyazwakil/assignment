package com.Neyaz.InstaBackend.repository;

import com.Neyaz.InstaBackend.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}

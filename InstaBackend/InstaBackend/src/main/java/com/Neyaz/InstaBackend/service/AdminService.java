package com.Neyaz.InstaBackend.service;


import com.Neyaz.InstaBackend.repository.IAdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;
}

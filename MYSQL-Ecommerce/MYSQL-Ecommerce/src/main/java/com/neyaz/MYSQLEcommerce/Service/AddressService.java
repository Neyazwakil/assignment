package com.neyaz.MYSQLEcommerce.Service;

import com.neyaz.MYSQLEcommerce.Model.Address;
import com.neyaz.MYSQLEcommerce.Repository.IaddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IaddRepo iaddRepo;
    public void addaddress(Address address) {
        iaddRepo.save(address);
    }


}

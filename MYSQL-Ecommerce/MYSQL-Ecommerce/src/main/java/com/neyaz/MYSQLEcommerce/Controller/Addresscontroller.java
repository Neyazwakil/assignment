package com.neyaz.MYSQLEcommerce.Controller;

import com.neyaz.MYSQLEcommerce.Model.Address;
import com.neyaz.MYSQLEcommerce.Service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addresscontroller {
    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public void addaddress(@RequestBody Address address){
        addressService.addaddress(address);
    }

}

package com.neyaz.employeeaddress.Service;
import com.neyaz.employeeaddress.Model.Address;
import com.neyaz.employeeaddress.Repository.IAddRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddRepo iAddRepo;
    public List<Address> findAll() {
        return (List<Address>) iAddRepo.findAll();
    }

    public Optional<Object> findById(Long id) {
        return Optional.of(iAddRepo.findById(id));
    }

    public String save(Address address) {
        iAddRepo.save(address);
        return "Saved Successfully";
    }

    public String updateAddress(Long id, Address address) {
        Address existingAddress = iAddRepo.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setAddName(address.getAddName());
            iAddRepo.save(existingAddress);
            return "Address updated successfully";
        }
        return "Address not found";
    }

    public String deleteById(Long id) {
        iAddRepo.deleteById(id);
        return "Deleted Sucsessfully";
    }
}

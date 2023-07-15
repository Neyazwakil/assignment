package com.neyaz.MappingPractice.Service;

import com.neyaz.MappingPractice.Model.Address;
import com.neyaz.MappingPractice.Repository.AddressRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address>getAllAddress(){
        return addressRepository.findAll();
    }
    public Address getAddressById(String Id) {
        return addressRepository.findById(Id).orElse(null);
    }
    public Address createAddress(Address address){
        return addressRepository.save(address);

    }
    public Address updateAddress(Address address){
        return addressRepository.save(address);

    }
    public void deleteAddress(String id) {
        addressRepository.deleteById(id);

    }
}

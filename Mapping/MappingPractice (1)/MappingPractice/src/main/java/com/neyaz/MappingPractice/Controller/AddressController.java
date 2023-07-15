package com.neyaz.MappingPractice.Controller;

import com.neyaz.MappingPractice.Model.Address;
import com.neyaz.MappingPractice.Service.AddressService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Data
@RestController
@RequestMapping("/address")
public class AddressController {
private final AddressService addressService;
@Autowired
    @GetMapping
    public List<Address> getAllAddress(){
    return  addressService.getAllAddress();
}
@GetMapping("/{Id}")
    public  Address getAddressById(@PathVariable("Id")String Id){

    return  addressService.getAddressById(Id);
}
@PostMapping
    public Address createAddress(@RequestBody Address address){
    return addressService.createAddress(address);
}
@PutMapping("/{Id}")
    public Address UpdateAddress(@PathVariable("Id") Long Id, @RequestBody Address address){
    return addressService.updateAddress(address);
}
@DeleteMapping("/{Id}")
    public  void deleteAddress(@PathVariable ("Id")String Id){
    addressService.deleteAddress(Id);
}


}

package com.neyaz.MappingPractice.Repository;

import com.neyaz.MappingPractice.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {
}

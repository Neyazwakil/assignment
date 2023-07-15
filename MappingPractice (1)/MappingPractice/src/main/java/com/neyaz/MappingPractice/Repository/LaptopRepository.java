package com.neyaz.MappingPractice.Repository;

import com.neyaz.MappingPractice.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,String> {
}

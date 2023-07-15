package com.neyaz.MappingPractice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    private  String LaptopID;
    private String name;
    private String brand;
    private Integer price;
    @OneToOne
    private  Student student;
}

package com.neyaz.MappingPractice.Controller;

import com.neyaz.MappingPractice.Model.Laptop;
import com.neyaz.MappingPractice.Service.LaptopService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Data
@RestController
@RequestMapping("/laptops")
public class LaptopController {
    public final LaptopService laptopService;
    @Autowired
    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable("id") String id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable("id") String id, @RequestBody Laptop laptop) {
        laptop.setLaptopID(id);
        return laptopService.updateLaptop(laptop);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable("id") String id) {
        laptopService.deleteLaptop(id);
    }
}

package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @Autowired
Car c;

    @GetMapping("name")
    public String getName(){
       return c.colour();
    }

}

package org.example;


import org.springframework.stereotype.Component;

@Component
public class Car {
String colour="red";

public Car(){
    System.out.print("car object is created");
}
    public String colour(){
       return colour;
    }
}

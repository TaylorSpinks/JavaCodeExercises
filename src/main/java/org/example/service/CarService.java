package org.example.service;

import org.example.entities.Car;

public class CarService {
    public static Boolean isCarVintage(Car car){
        return car.isVintage(car.getManufactureYear());
    }
}

package org.example.entities;

import java.util.Objects;

public class Car {
    private String make;
    private String model;
    private int purchaseYear;
    private int manufactureYear;
    private static final int vintageStartYear = 1919;
    private static final int vintageEndYear = 1930;

    public Car(String make, String model, int purchaseYear, int manufactureYear) {
        this.make = make;
        this.model = model;
        this.purchaseYear = purchaseYear;
        this.manufactureYear = manufactureYear;
    }

    public String getCarInfo() {
        return make + " " + model + " " + manufactureYear + " " + purchaseYear;
    }

    public String getHashCodeString() {
        return make + " " + model + " " + manufactureYear;
    }

    private int calculateOwnerShipLength() {
        return purchaseYear - manufactureYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Car otherCar = ((Car) obj); // cast
        return this.make.equals(otherCar.make) && this.model.equals(otherCar.model)
                && this.manufactureYear == otherCar.manufactureYear;
    }

    @Override
    public int hashCode(){
        return Objects.hash(make, model, manufactureYear);
    }

    public Boolean isVintage(int manufactureYear) {
        return manufactureYear >= vintageStartYear && manufactureYear <= vintageEndYear;
    }

    public int getOwnershipLength() {
        return calculateOwnerShipLength();
    }

    public int getManufactureYear() {
        return manufactureYear;
    }
}

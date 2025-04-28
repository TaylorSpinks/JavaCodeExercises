package org.example;

import org.example.entities.Car;
import org.example.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        runCarExercises();
        runDrillExercises();
    }
    public static void runCarExercises(){
        Car vintageCar1 = new Car("Ford", "Model T", 2005, 1920);
        Car vintageCar2 = new Car("Chevrolet", "Bel Air", 2008, 1957);

        Car modernCar3 = new Car("Tesla", "Model 3", 2021, 2021);
        Car modernCar4 = new Car("Subaru", "Outback", 2016, 2015);
        Car modernCar5 = new Car("Ford", "F-150", 2017, 2016);


        System.out.println(CarService.isCarVintage(modernCar3));
        System.out.println(CarService.isCarVintage(vintageCar1));

        ArrayList<Car> myCars = new ArrayList<>();
        myCars.add(vintageCar1);
        myCars.add(vintageCar2);
        myCars.add(modernCar3);
        myCars.add(modernCar4);
        myCars.add(modernCar5);

        myCars.remove(modernCar3);

        Car myChevrolet = myCars.get(2);
        System.out.println(myChevrolet.getCarInfo());
        System.out.println(myChevrolet.isVintage(myChevrolet.getManufactureYear()));

        HashSet<Car> myCarHashSet = new HashSet<>();
        myCarHashSet.add(vintageCar1);
        myCarHashSet.add(vintageCar2);
        myCarHashSet.add(vintageCar2);
        myCarHashSet.add(modernCar3);
        myCarHashSet.add(modernCar4);
        myCarHashSet.add(modernCar5);
        myCarHashSet.add(modernCar5);

        for(Car car : myCarHashSet){
            System.out.println(car.hashCode() + " " + car.getCarInfo());
        }

        System.out.println("---------------------------------");

        HashMap<String, Car> myCarHashMap = new HashMap<>();
        myCarHashMap.put(vintageCar1.getHashCodeString(),vintageCar1);
        myCarHashMap.put(vintageCar2.getHashCodeString(),vintageCar2);
        myCarHashMap.put(vintageCar2.getHashCodeString(),vintageCar2);
        myCarHashMap.put(modernCar3.getHashCodeString(),modernCar3);
        myCarHashMap.put(modernCar5.getHashCodeString(),modernCar5);
        myCarHashMap.put(modernCar5.getHashCodeString(),modernCar5);

        for (HashMap.Entry<String, Car> car : myCarHashMap.entrySet()) {
            System.out.println(car.getKey() + " " + car.getValue());
        }

    }

    public static void runDrillExercises(){
        int [] arr = {2,3,1,2,4,6,8,9,9,0};

        System.out.println(findMax(arr));

        System.out.println(Arrays.toString(reverseArr(arr)));
    }

    public static int findMax(int[] arr){
        int maxValue = 0;

        for(int number : arr){
            if(number > maxValue){
                maxValue = number;
            }
        }
        return maxValue;
    }

    public static int[] reverseArr(int[] arr) {
        for (int i=0,j=arr.length-1; i < arr.length/2; i++,j--){
            int tempOfI = arr[i];
            arr[i] = arr[j];
            arr[j] = tempOfI;
        }
        return arr;
    }
}
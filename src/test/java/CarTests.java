import org.example.entities.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTests {
    @Test
    void testPrintCarString(){
        Car myCar = new Car("Toyota", "Hilux", 2010, 2005);

        assertEquals("Toyota Hilux 2005", myCar.getCarInfo());
    }

    @Test
    void testGetOwnershipLength(){
        Car myCar = new Car("Toyota", "Hilux", 2010, 2005);

        assertEquals(5, myCar.getOwnershipLength());
    }

    @Test
    void testVintageCarWhenIsVintage(){
        Car myCar = new Car("Ford", "Model T", 2005, 1920);

        assertEquals(true, myCar.isVintage(myCar.getManufactureYear()));
    }

    @Test
    void testVintageCarWhenIsNotVintage(){
        Car myCar = new Car("Ford", "Mustang", 2010, 2010);

        assertEquals(false, myCar.isVintage(myCar.getManufactureYear()));
    }

    @Test
    void testGetCarFromHashMap(){
        Car vintageCar1 = new Car("Ford", "Model T", 2005, 1920);
        Car vintageCar2 = new Car("Chevrolet", "Bel Air", 2008, 1957);

        Car modernCar3 = new Car("Tesla", "Model 3", 2021, 2021);
        Car modernCar4 = new Car("Subaru", "Outback", 2016, 2015);
        Car modernCar5 = new Car("Ford", "F-150", 2017, 2016);

    }
}

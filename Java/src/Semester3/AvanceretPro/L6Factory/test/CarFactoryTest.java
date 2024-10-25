import org.junit.jupiter.api.Test;
import simplefactory.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void test_createCar_ReturnCorrectType() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car sedan, convertible, pickup;


        //ACT
        sedan = carFactory.createCar(CarType.Sedan, 0, 0);
        convertible = carFactory.createCar(CarType.Convertible, 0, 0);
        pickup = carFactory.createCar(CarType.Pickup, 0, 0);


        //ASSERT
        assertEquals(0, sedan.getSeats());
        assertEquals(0, convertible.getSeats());
        assertInstanceOf(Sedan.class, sedan);
        assertInstanceOf(Convertible.class, convertible);
        assertInstanceOf(Pickup.class, pickup);

    }

    @Test
    void test_createCar_ReturnCorrect_SeatsAndDors() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car sedan, convertible, pickup;


        //ACT
        sedan = carFactory.createCar(CarType.Sedan, 0, 0);
        convertible = carFactory.createCar(CarType.Convertible, 2, 2);
        pickup = carFactory.createCar(CarType.Pickup, 4, 4);


        //ASSERT
        assertInstanceOf(Sedan.class, sedan);
        assertInstanceOf(Convertible.class, convertible);
        assertInstanceOf(Pickup.class, pickup);
    }

    @Test
    void test_createCar_ReturnCorrectFuelType() {
        //Arrange
        CarFactory carFactory = new CarFactory();
        Car sedan, convertible, pickup;


        //ACT & Assert
        sedan = carFactory.createCar(CarType.Sedan, FuelType.Gasoline, 0, 0);
        assertTrue(sedan.getFuel() instanceof Gasoline);

        convertible = carFactory.createCar(CarType.Convertible, FuelType.Electricity, 0, 0);
        assertTrue(convertible.getFuel() instanceof Electricity);

        pickup = carFactory.createCar(CarType.Pickup, FuelType.Hybrid, 0, 0);
        assertTrue(pickup.getFuel() instanceof Hybrid);


        //ASSERT
        assertEquals(0, sedan.getSeats());
        assertEquals(0, convertible.getSeats());
        assertInstanceOf(Sedan.class, sedan);
        assertInstanceOf(Convertible.class, convertible);
        assertInstanceOf(Pickup.class, pickup);

    }
}

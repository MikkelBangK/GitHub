package factorymethod.Factories;

import factorymethod.Car;
import factorymethod.CarType;
import factorymethod.FuelType;

public class TeslaFactory extends CarFactory{
    @Override
    public Car createCar(String model, CarType carType, FuelType fuelType, int seats, int doors) {
        return super.createCar(model, carType, fuelType, seats, doors);
    }
}

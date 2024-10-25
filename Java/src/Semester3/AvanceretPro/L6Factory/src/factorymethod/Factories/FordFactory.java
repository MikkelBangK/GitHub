package factorymethod.Factories;

import factorymethod.Car;
import factorymethod.CarType;
import factorymethod.Ford.Focus;
import factorymethod.FuelType;

public class FordFactory extends CarFactory{
    @Override
    public Car createCar(CarType carType, FuelType fuelType, int seats, int doors) {
        if (carType.equals(CarType.Sedan)){
            Car focus = createCar(CarType.Sedan, FuelType.Gasoline, 4, 4);
            return focus;
        } else if (carType.equals(CarType.Convertible)){
            Car mustang = createCar(CarType.Convertible, FuelType.Hybrid, 2, 2);
            return mustang;
        } else if (carType.equals(CarType.Pickup)) {
            Car maverick = createCar(CarType.Pickup, FuelType.Electricity, 2, 2);
            return maverick;
        } else {
            return null;
        }
    }
}

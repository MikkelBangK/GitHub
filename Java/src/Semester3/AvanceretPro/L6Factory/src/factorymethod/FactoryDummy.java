package factorymethod;

public class FactoryDummy {

    public Car createCar(CarType carType, FuelType fuelType, int seats, int doors){
        Car newCar = createCar(carType, seats, doors);
        if (fuelType == FuelType.Gasoline){
            newCar.setFuel(new Gasoline());
        } else if (fuelType == FuelType.Electricity){
            newCar.setFuel(new Electricity());
        }else if (fuelType == FuelType.Hybrid){
            newCar.setFuel(new Hybrid());
        }
        return newCar;
    }
    public Car createCar(CarType carType, int seats, int doors) {
        Car newCar;
        if (carType == CarType.Sedan) {
            newCar = new Sedan();
        } else if (carType == CarType.Convertible) {
            newCar = new Convertible();
        } else if (carType == CarType.Pickup) {
            newCar = new Pickup();
        } else {
            return null;
        }
        newCar.setSeats(seats);
        newCar.setDoors(doors);

        return newCar;
    }
    public Car createCar(String model, CarType carType, FuelType fuelType, int seats, int doors){
        Car newCar = createCar( model, carType, fuelType, seats, doors);
        if (newCar.equals("Tesla")){
            newCar.setFuel(new Electricity());

            if (fuelType == FuelType.Gasoline){
                newCar.setFuel(new Gasoline());
            } else if (fuelType == FuelType.Electricity){
                newCar.setFuel(new Electricity());
            }else if (fuelType == FuelType.Hybrid){
                newCar.setFuel(new Hybrid());
            }}
        if (carType == CarType.Sedan) {
            newCar = new Sedan();
        } else if (carType == CarType.Convertible) {
            newCar = new Convertible();
        } else if (carType == CarType.Pickup) {
            newCar = new Pickup();
        } else {
            return null;
        }
        newCar.setSeats(seats);
        newCar.setDoors(doors);
        newCar.setModel(model);
        return newCar;
    }

}

package simplefactory;

public abstract class Car {
    private int seats;
    private int doors;
    private Fuel fuel;

    public int getSeats() {return seats;}

    public int getDoors() {return doors;}

    public void setSeats(int seats) {this.seats = seats;}

    public void setDoors(int doors) {this.doors = doors;}

    public Fuel getFuel() {return fuel;}

    public void setFuel(Fuel fuel) {this.fuel = fuel;}
}

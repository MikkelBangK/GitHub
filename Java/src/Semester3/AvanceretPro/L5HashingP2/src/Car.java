import java.util.Objects;

public class Car {
    private String regNumber;
    private String brand;
    private String model;
    private String color;

    public Car(String regNumber, String brand, String model, String color) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) && Objects.equals(brand, car.brand);
    }
    public boolean equalsSelfMade(Object o){
        if (o instanceof Car){
            Car oCar = (Car) o;
            return oCar.brand.equals(this.brand) && oCar.regNumber.equals(this.regNumber);
        }
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(regNumber, brand);
    }
}

public class Whiskey {

    private String name;
    private String origin;
    private String color;
    private double alcohol;

    public Whiskey(String name, String origin, String color, double alcohol) {
        this.name = name;
        this.origin = origin;
        this.color = color;
        this.alcohol = alcohol;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getColor() {
        return color;
    }

    public double getAlcohol() {
        return alcohol;
    }

    @Override
    public String toString() {
        return name;
    }
}

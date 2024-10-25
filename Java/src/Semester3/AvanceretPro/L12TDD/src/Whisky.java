public class Whisky {

    private String title;
    private String country;
    private String colour;
    private double proof; // 100 proof are equivalent to 57.1% alcohol (ABV)

    public Whisky(String title, String country, String colour, double proof) {
        this.title = title;
        this.country = country;
        this.colour = colour;
        this.proof = proof;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public String getColour() {
        return colour;
    }

    public double getProof() {
        return proof;
    }

    @Override
    public String toString() {
        return title;
    }
}

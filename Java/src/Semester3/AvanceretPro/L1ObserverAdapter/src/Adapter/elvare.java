package Adapter;

public class elvare extends vare {

    public elvare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return getPris()*0.30;
    }
}

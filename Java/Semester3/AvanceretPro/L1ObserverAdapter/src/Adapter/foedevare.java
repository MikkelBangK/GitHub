package Adapter;

public class foedevare extends vare {
    public foedevare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return getPris()*0.05;
    }
}

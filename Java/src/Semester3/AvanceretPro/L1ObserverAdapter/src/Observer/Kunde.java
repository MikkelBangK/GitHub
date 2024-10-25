package Observer;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    ArrayList<BogTitel> titler = new ArrayList<>();

    public Kunde(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
    public ArrayList<BogTitel> getTitler() {
        return titler;
    }
    public void addTitel(BogTitel bogTitel){
        if (!titler.contains(bogTitel)){
            titler.add(bogTitel);
        }
    }
}

package Observer;

import java.util.Formattable;
import java.util.HashSet;
import java.util.Set;

public class Saelger implements Observer {
    private String navn;

    public Saelger(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public void update(Subject s) {
        BogTitel bogTitel = (BogTitel) s;

        if (s instanceof BogTitel){
            Set<Subject> setListe = new HashSet<>();
            for(Kunde kunde : bogTitel.getKunder()){
                for (BogTitel b : kunde.getTitler()){
                    if (b != bogTitel){
                        setListe.add(b);
                    }
                }
            }
            System.out.println("Her er en liste af de bøger som ejerne af denne bog også har købt");
            for (Subject subject : setListe){
                System.out.println(((BogTitel) subject).getTitel());
            }
        }
    }
}

package Observer;

public class Indkoeber implements Observer{
    private String navn;

    public Indkoeber(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel) {
            BogTitel bogTitel = (BogTitel) s;
            if (((BogTitel) s).getAntal() < 6) {
                System.out.println("Lagerbeholdning af " + bogTitel.getTitel() + " er mindre end 6, der skal bestilles nye bøger.");
                System.out.println("Der er bestilt 10 nye eksemplarer af " + bogTitel.getTitel());
                bogTitel.indkoebTilLager(10);
            }
        }
    }
}

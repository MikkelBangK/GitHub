package Observer;

import java.util.ArrayList;

public class BogTitel implements Subject{
    private String titel;
    private int antal;
    ArrayList<Kunde> kunder = new ArrayList<>();
    ArrayList<Observer> observers = new ArrayList<>();

    public BogTitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public ArrayList<Kunde> getKunder() {
        return kunder;
    }

    public void addKunde(Kunde kunde){
        if (!kunder.contains(kunde)){
            kunder.add(kunde);
        }
    }
    public void indkoebTilLager(int antal){
        this.antal += antal;
    }
    public void etKoeb(Kunde k){
        kunder.add(k);
        antal--;
        k.getTitler().add(this);
        notifyObserver();
    }
    public void notifyObserver(){
        for (Observer observer : observers){
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer o) {
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)){
            observers.remove(o);
        }
    }
}

package Adapter;

public class spiritusAdapter extends vare {
    Adapter.spiritus spiritus;

    public spiritusAdapter(Adapter.spiritus spiritus) {
        super(spiritus.getPrisen(), spiritus.getBetgenelse());
        this.spiritus = spiritus;
    }

    @Override
    public int getPris() {
        return spiritus.getPrisen();
    }
    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }

}

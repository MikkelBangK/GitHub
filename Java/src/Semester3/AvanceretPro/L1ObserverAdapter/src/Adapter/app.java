package Adapter;

public class app {
    public static void main(String[] args) {
        spiritus spiritus = new spiritus(100, "Vodka");
        spiritusAdapter spiritusAdapter = new spiritusAdapter(spiritus);
        System.out.println("Type: " + spiritusAdapter.getNavn() + "\nPris: " + spiritusAdapter.getPris() + "\nMoms: " + spiritusAdapter.beregnMoms());
    }
}

package Opgave1;

public class appp {
    public static void main(String[] args) {
        Opgave1.MyString ms = new Opgave1.MyString("1v1 path of titans");
        Opgave1.InputThread it = new Opgave1.InputThread(ms);
        Opgave1.OutputThread ot = new Opgave1.OutputThread(ms);

        it.start();
        ot.start();
        try {
            it.join();
            ot.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}

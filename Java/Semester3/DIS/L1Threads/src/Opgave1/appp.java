package Opgave1;

public class appp {
    public static void main(String[] args) {
        MyString ms = new MyString("1v1 path of titans");
        InputThread it = new InputThread(ms);
        OutputThread ot = new OutputThread(ms);

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

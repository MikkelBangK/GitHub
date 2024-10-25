package Opgave1;

public class OutputThread extends Thread{
private Opgave1.MyString ms;

    public OutputThread(Opgave1.MyString ms) {
        this.ms = ms;
    }
    public void run(){
        while (true){
            try {
                {
                    sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ms.getStreng());
        }
    }
}

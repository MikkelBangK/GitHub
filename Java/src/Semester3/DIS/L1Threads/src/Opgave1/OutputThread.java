package Opgave1;

public class OutputThread extends Thread{
private MyString ms;

    public OutputThread(MyString ms) {
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

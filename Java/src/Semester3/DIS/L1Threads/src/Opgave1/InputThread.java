package Opgave1;

import java.util.Scanner;

public class InputThread extends Thread{
    private MyString ms;

    public InputThread(MyString ms) {
        this.ms = ms;
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true){
            String streng = sc.nextLine();
            ms.setStreng(streng);
            sc.close();
        }
    }
}

package Opgave2;

import java.util.ArrayList;
import java.util.List;

public class Thread1 extends Thread{
    List<Integer> list = new ArrayList<Integer>();
    int start;
    int slut;

    public Thread1(List<Integer> list, int start, int slut) {
        this.list = list;
        this.start = start;
        this.slut = slut;
    }
    public void run(){
        FletteSortering.mergesort(list, start, slut);
    }
}

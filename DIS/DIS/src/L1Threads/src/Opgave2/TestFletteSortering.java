package Opgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFletteSortering {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<Integer>();
            Random r = new Random();
            for (int i = 0; i < 10000000; i++) {
                list.add(Math.abs(r.nextInt() % 10000));
            }
            //System.out.println(list);
            Opgave2.FletteSortering sort = new Opgave2.FletteSortering();
            long l1, l2;
            l1 = System.nanoTime();
            //sort.mergesort(list, 0, list.size() - 1);
            sort.threadmergesort(list, 0, list.size()-1);
            l2 = System.nanoTime();
            System.out.println();
            System.out.println("Koeretiden var " + (l2 - l1) / 1000000);
            System.out.println();
            //System.out.println(list);
            // Køretid uden threads (599, 632, 597, 588, 588)
        }
    }

